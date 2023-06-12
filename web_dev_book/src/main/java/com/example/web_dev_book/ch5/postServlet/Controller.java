package com.example.web_dev_book.ch5.postServlet;

import com.example.web_dev_book.ch4.enhanced.ControllerHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns={"/ch5/postServlet/Controller"})
public class Controller extends HttpServlet {

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

