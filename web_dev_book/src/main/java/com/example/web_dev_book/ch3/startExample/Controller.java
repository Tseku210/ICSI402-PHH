package com.example.web_dev_book.ch3.startExample;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns={"/ch3/startExample/Controller"})
public class Controller extends HttpServlet
{

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException
    {

        String address;

        if (request.getParameter("processButton") != null)
        {
            address = "Process.jsp";
        }
        else if (request.getParameter("confirmButton") != null)
        {
            address = "Confirm.jsp";
        }
        else
        {
            address = "Edit.jsp";
        }

        RequestDispatcher dispatcher =
                request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }
}
