package com.example.web_dev_book.ch6.complexInit;


import com.example.web_dev_book.shared.ButtonMethod;
import com.example.web_dev_book.shared.HelperBaseCh6;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ControllerHelper extends HelperBaseCh6 {

    private RequestDataInit data = new RequestDataInit();

    public ControllerHelper(
            HttpServlet servlet,
            HttpServletRequest request,
            HttpServletResponse response) {
        super(servlet, request, response);
    }

    public Object getData() {
        return data;
    }

    public void copyFromSession(Object sessionHelper) {
        if (sessionHelper.getClass() == this.getClass()) {
            ControllerHelper helper =
                    (ControllerHelper) sessionHelper;
            data = helper.data;
            checked = helper.checked;
            selected = helper.selected;
        }
    }

    public void resetNullable() {
        //Checkbox
        data.setExtra(null);
        //Mulitple select
        data.setTeam(null);
        //Radio
        data.setHappiness(0);
    }

    protected String jspLocation(String page) {
        return "/WEB-INF/classes/ch6/complexInit/" + page;
    }

    @ButtonMethod(buttonName="editButton", isDefault=true)
    public String editMethod() {
        return jspLocation("Edit.jsp");
    }

    @ButtonMethod(buttonName="confirmButton")
    public String confirmMethod() {
        //Create new data and populate from the query string
        resetNullable();
        fillBeanFromRequest(data);
        setCheckedAndSelected(data);
        //The next JSP address depends on the validity of the data.
        String address;
        if (isValid(data)) {
            address = jspLocation("Confirm.jsp");
        } else {
            address = jspLocation("Edit.jsp");
        }
        return address;
    }

    @ButtonMethod(buttonName="processButton")
    public String processMethod() {
        return jspLocation("Process.jsp");
    }

    @Override
    protected void doGet()
            throws ServletException, java.io.IOException
    {
        //Create a new helper object in the session.
        addHelperToSession("helper", SessionData.IGNORE);

        //ControllerEdit.jsp is the default. If the button is null, then this is
        //the page that will display.
        String address = editMethod();

        request.getRequestDispatcher(address).forward(request, response);
    }

    @Override
    public void doPost()
            throws ServletException, java.io.IOException
    {
        //Check if there is already a helper in the session.
        addHelperToSession("helper", SessionData.READ);

        String address = executeButtonMethod();

        request.getRequestDispatcher(address).forward(request, response);
    }

}

