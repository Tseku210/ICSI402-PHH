package com.example.web_dev_book.ch6.complexInit;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(urlPatterns={"/ch6/complexInit/Controller"})
public class Controller extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        ControllerHelper helper = new ControllerHelper(this, request, response);
        helper.doGet();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        ControllerHelper helper = new ControllerHelper(this, request, response);
        helper.doPost();
    }

}

