package com.example.web_dev_book.ch8.services.google;


import com.example.web_dev_book.shared.ButtonMethod;
import com.example.web_dev_book.shared.HelperBaseCh5;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ControllerHelper extends HelperBaseCh5 {

    private RequestDataServices data =
            new RequestDataServices();

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
            data = ((ControllerHelper) sessionHelper).data;
        }
    }

    protected String jspLocation(String page) {
        return "/WEB-INF/classes/ch8/services/google/"
                + page;
    }

    @ButtonMethod(buttonName = "editButton", isDefault = true)
    public String editMethod() {
        return jspLocation("Edit.jsp");
    }

    @ButtonMethod(buttonName = "confirmButton")
    public String confirmMethod() {
        //Populate from the query string
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

    @ButtonMethod(buttonName = "processButton")
    public String processMethod() {

        try {
            String address = data.getAddress();
            java.lang.Integer zoom = 15;
            String iframe = "true";

            RestResponse result =
                    GoogleMapService.getGoogleMap(address, zoom, iframe);
            request.setAttribute("googleMap", result.getDataAsString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return jspLocation("Process.jsp");
    }

    @Override
    public void doGet()
            throws ServletException, java.io.IOException {
        //Call the method with false to place a new helper in the session
        addHelperToSession("helper", SessionData.IGNORE);

        String address = editMethod();

        request.getRequestDispatcher(address).forward(request, response);
    }

    @Override
    public void doPost()
            throws ServletException, java.io.IOException {
        //Call the method with false to place a new helper in the session
        addHelperToSession("helper", SessionData.READ);

        String address = executeButtonMethod();

        request.getRequestDispatcher(address).forward(request, response);
    }
}

