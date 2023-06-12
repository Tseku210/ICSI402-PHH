package com.example.web_dev_book.ch4.enhanced;

import com.example.web_dev_book.ch3.defaultValidate.RequestDataDefault;
import com.example.web_dev_book.shared.ButtonMethod;
import com.example.web_dev_book.shared.HelperBaseCh4;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
public class ControllerHelper extends HelperBaseCh4 {

    private RequestDataDefault data;

    public ControllerHelper(
            HttpServlet servlet,
            HttpServletRequest request,
            HttpServletResponse response) {
        super(servlet, request, response);
        data = new RequestDataDefault();
    }

    public Object getData() {
        return data;
    }

    public void copyFromSession(Object sessionHelper) {
        if (sessionHelper.getClass() == this.getClass()) {
            data = ((ControllerHelper)sessionHelper).data;
        }
    }

    protected String jspLocation(String page) {
        return "/ch4/enhanced/" + page;
    }

    @ButtonMethod(buttonName="editButton", isDefault=true)
    public String editMethod() {
        return jspLocation("Edit.jsp");
    }

    @ButtonMethod(buttonName="confirmButton")
    public String confirmMethod() {
        fillBeanFromRequest(data);
        return jspLocation("Confirm.jsp");
    }

    @ButtonMethod(buttonName="processButton")
    public String processMethod() {
        return jspLocation("Process.jsp");
    }

    @Override
    public void doGet()
            throws ServletException, IOException
    {
        addHelperToSession("helper", SessionData.READ);

        String address = executeButtonMethod();

        request.getRequestDispatcher(address)
                .forward(request, response);
    }

}
