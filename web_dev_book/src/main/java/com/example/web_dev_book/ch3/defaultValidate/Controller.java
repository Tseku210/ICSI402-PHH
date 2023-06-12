package com.example.web_dev_book.ch3.defaultValidate;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns={"/ch3/defaultValidate/Controller"})
public class Controller extends HttpServlet {
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        RequestDataDefault data = new RequestDataDefault();
        request.getSession().setAttribute("refData", data);

        data.setHobby(request.getParameter("hobby"));
        data.setAversion(request.getParameter("aversion"));

        String address;
        if (request.getParameter("processButton") != null)
        {
            address = "/ch3/dataBean/Process.jsp";
        }
        else if (request.getParameter("confirmButton") != null)
        {
            address = "/ch3/dataBean/Confirm.jsp";
        }
        else
        {
            address = "/ch3/dataBean/Edit.jsp";
        }

        RequestDispatcher dispatcher =
                request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }
}
