package com.example.web_dev_book.ch8.services.google;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        //ControllerEdit.jsp is only page that a GET request will see.
        ControllerHelper helper = new ControllerHelper(this, request, response);
        helper.doGet();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        //ControllerEdit.jsp is only page that a GET request will see.
        ControllerHelper helper = new ControllerHelper(this, request, response);
        helper.doPost();
    }

}
