package com.example.web_dev_book.ch3.reorganised;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns={"/ch3/reorganised/Controller"})
public class Controller extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        ControllerHelper helper =
                new ControllerHelper(this, request, response);
        helper.doGet();
    }
}
