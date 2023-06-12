package com.example.web_dev_book.ch8.services.paypal;

import ch7.catalogue.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


public class Controller extends HttpServlet {

    @Override
    public void init() {
        ControllerHelper.initHibernate(this);
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException, ServletException {
        ControllerHelper helper =
                new ControllerHelper(this, request, response);
        helper.doGet();
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws IOException, ServletException {
        ControllerHelper helper =
                new ControllerHelper(this, request, response);
        helper.doPost();
    }

}
