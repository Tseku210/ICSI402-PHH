package com.example.web_dev_book.shared;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


public abstract class HelperBaseCh6 extends HelperBaseCh5 {

    protected Map<String, Map<String, String>> checked =
            new HashMap<String, Map<String, String>>();
    protected Map<String, Map<String, String>> selected =
            new HashMap<String, Map<String, String>>();

    public HelperBaseCh6(
            HttpServlet servlet,
            HttpServletRequest request,
            HttpServletResponse response) {
        super(servlet, request, response);
    }

    protected void setCheckedAndSelected(Object data) {
        setCheckedAndSelected(data, data.getClass());
    }

    protected void setCheckedAndSelected(Object data,
                                         Class clazz) {
        Method[] allMethods = clazz.getDeclaredMethods();
        Method methodDefault = null;
        for (Method method : allMethods) {
            SetByAttribute propAnnotation =
                    method.getAnnotation(SetByAttribute.class);
            if (propAnnotation != null) {
                String property = method.getName();
                java.util.regex.Pattern pattern =
                        java.util.regex.Pattern.compile("get(.+)");
                java.util.regex.Matcher matcher =
                        pattern.matcher(property);
                if (!matcher.matches()) {
                    logger.error(property + " must be an accessor.");
                } else {
                    property = matcher.group(1);
                    property = property.substring(0, 1).toLowerCase()
                            + property.substring(1);
                    clearProperty(property,
                            propAnnotation.type());
                    if (method.getReturnType().isArray()) {
                        Object[] result =
                                (Object[]) invokeGetter(data, method);
                        if (result != null) {
                            for (Object obj : result) {
                                addChoice(property, obj.toString(),
                                        (AttributeType) propAnnotation.type());
                            }
                        }
                    } else {
                        Object result = invokeGetter(data, method);
                        if (result != null) {
                            addChoice(property, result.toString(),
                                    (AttributeType) propAnnotation.type());
                        }
                    }
                }
            }
        }
        Class parentClass = clazz.getSuperclass();
        if (parentClass != null) {
            setCheckedAndSelected(data, parentClass);
        }
    }

    protected Object invokeGetter(Object obj, Method method) {
        Object result = null;
        try {
            result = method.invoke(obj, (Object[]) null);
        } catch (IllegalAccessException iae) {
            logger.error("(invoke) Accessor needs public access",
                    iae);
        } catch (InvocationTargetException ite) {
            logger.error("(invoke) Accessor threw an exception",
                    ite);
        }
        return result;
    }

    public Map getChecked() {
        return checked;
    }

    public Map getSelected() {
        return selected;
    }

    public void addChecked(String group, String item) {
        if (checked.get(group) == null) {
            checked.put(group,
                    new HashMap<String, String>());
        }
        checked.get(group).put(item, "checked");
    }

    public void addSelected(String list, String item) {
        if (selected.get(list) == null) {
            selected.put(list,
                    new HashMap<String, String>());
        }
        selected.get(list).put(item, "selected");
    }

    public void addChoice(String list,
                          String item,
                          AttributeType type) {
        if (type == null) {
            return;
        }
        if (AttributeType.CHECKED == type) {
            addChecked(list, item);
        }
        if (AttributeType.SELECTED == type) {
            addSelected(list, item);
        }
    }

    public void clearProperty(String property,
                              AttributeType type) {
        Map<String, String> propMap;
        if (AttributeType.CHECKED == type) {
            propMap = checked.get(property);
            if (propMap != null) {
                propMap.clear();
            }
        } else if (AttributeType.SELECTED == type) {
            propMap = selected.get(property);
            if (propMap != null) {
                propMap.clear();
            }
        }
    }

    public void clearMaps() {
        checked.clear();
        selected.clear();
    }
}
