
package com.example.web_dev_book.ch7.accountLogin;


import java.io.IOException;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch7.accountLogin.RequestDataAccount;

public class Controller extends HttpServlet
{
    public void init() {
        boolean create = Boolean.parseBoolean(getInitParameter("create"));
        ControllerHelper.initHibernate(create);
    }

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
