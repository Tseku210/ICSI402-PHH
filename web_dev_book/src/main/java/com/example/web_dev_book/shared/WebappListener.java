package com.example.web_dev_book.shared;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;


@WebListener
public class WebappListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce)
    {}

    public void contextDestroyed(ServletContextEvent sce)
    {
        try {
            Enumeration<Driver> enumer = DriverManager.getDrivers();
            while (enumer.hasMoreElements()) {
                System.out.println("Forms: deregisterd driver");
                DriverManager.deregisterDriver(enumer.nextElement());
            }
        } catch (java.sql.SQLException se) {
            se.printStackTrace();
        }
        HibernateHelper.closeFactory();
    }
}

