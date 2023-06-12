package com.example.web_dev_book.shared;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.validator.engine.PathImpl;

public abstract class HelperBaseCh5 extends HelperBaseCh4 {

    public HelperBaseCh5(
            HttpServlet servlet,
            HttpServletRequest request,
            HttpServletResponse response) {
        super(servlet, request, response);
    }

    protected static final ValidatorFactory validatorFactory
            = Validation.buildDefaultValidatorFactory();
    protected static final Validator validator
            = validatorFactory.getValidator();

    //For JSP access, use a map that is created from the validation messages.
    java.util.Map<String, String> errorMap =
            new java.util.HashMap<String, String>();

    public void setErrors(Object data) {

        Set<ConstraintViolation<Object>> violations =
                validator.validate(data);

        errorMap.clear();
        if (! violations.isEmpty()) {
            for(ConstraintViolation<Object> msg : violations) {
                PathImpl value = (PathImpl) msg.getPropertyPath();
                errorMap.put((String) value.getLeafNode().getName(),
                        msg.getMessage());
            }
        }
    }

    //clear the error map
    public void clearErrors() {
        if (errorMap != null) {
            errorMap.clear();
        }
    }

    //isValidProperty must be called in order to set the error messages
    public boolean isValid(Object data) {
        setErrors(data);
        return errorMap.isEmpty();
    }

    //isValidProperty must be called to set the error messages.
    //This was implemented this way so that the first access to an
    //application will not report errors.
    public java.util.Map getErrors() {
        return errorMap;
    }

    public boolean isValidProperty(String name) {
        String msg = errorMap.get(name);
        return msg == null || msg.equals("");
    }

}


