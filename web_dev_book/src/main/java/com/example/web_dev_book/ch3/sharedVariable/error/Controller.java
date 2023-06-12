package com.example.web_dev_book.ch3.sharedVariable.error;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns={"/ch3/sharedVariable/error/Controller"})
public class Controller extends HttpServlet {

    public int accessCount = 0;

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        //ControllerEdit.jsp is the default. If the button
        //is null, then this is the page that will display.
        String address = "/ch3/sharedVariable/Edit.jsp";

        incrementSharedVariable();

        request.setAttribute("accessCount", accessCount);
        request.getRequestDispatcher(address)
                .forward(request, response);
    }

    public void incrementSharedVariable() {
        int temp = accessCount;
        temp++;
        System.out.println(temp);
        try {
            Thread.sleep(3000);
        } catch (java.lang.InterruptedException ie) {

        }
        accessCount = temp;
    }
}
