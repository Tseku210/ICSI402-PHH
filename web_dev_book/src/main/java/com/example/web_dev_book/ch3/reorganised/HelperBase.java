package com.example.web_dev_book.ch3.reorganised;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HelperBase {
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpServlet servlet;

    public HelperBase(HttpServlet servlet,
                      HttpServletRequest request,
                      HttpServletResponse response) {
        this.servlet = servlet;
        this.request = request;
        this.response = response;
    }
}

