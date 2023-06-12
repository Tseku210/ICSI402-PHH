package com.example.web_dev_book.ch6.complexForm;

import com.example.web_dev_book.shared.ButtonMethod;
import com.example.web_dev_book.shared.HelperBaseCh5;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ControllerHelper extends HelperBaseCh5 {

    private RequestDataComplex data
            = new RequestDataComplex();

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
            data = ((ControllerHelper)sessionHelper).data;
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
        return "/ch6/complexForm/" + page;
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
    public void doGet()
            throws ServletException, java.io.IOException
    {
        //Call the method with false to place a new helper in the session
        addHelperToSession("helper", SessionData.READ);

        //Edit.jsp is the only page that will be displayed from a GET request.
        String address = executeButtonMethod();

        request.getRequestDispatcher(address)
                .forward(request, response);
    }


}
