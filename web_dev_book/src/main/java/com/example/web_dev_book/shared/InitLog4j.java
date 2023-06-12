package com.example.web_dev_book.shared;


import jakarta.servlet.http.HttpServlet;
import org.apache.log4j.*;

import java.io.IOException;

public class InitLog4j extends HttpServlet {

    public void init() {
        String initPath = getInitParameter("logPath");
        String logPath = "/WEB-INF/logs/error.log";
        if (initPath != null) logPath = initPath;
        FileAppender appender = getAppender(logPath);
        if (appender == null) return;
        initLogger(null, appender, Level.ERROR);
        initLogger("org.apache.commmons.beanutils",
                appender, Level.DEBUG);
    }

    private FileAppender getAppender(String fileName) {
        RollingFileAppender appender = null;
        try {
            appender = new RollingFileAppender(
                    new PatternLayout("%-5p %c %t%n%29d - %m%n"),
                    getServletContext().getRealPath(fileName),
                    true);
            appender.setMaxBackupIndex(5);
            appender.setMaxFileSize("1MB");
        } catch (IOException ex) {
            System.out.println(
                    "Could not create appender for "
                            + fileName + ":"
                            + ex.getMessage());
        }
        return appender;
    }

    private void initLogger(String name,
                            FileAppender appender,
                            Level level)
    {
        Logger logger;
        if (name == null) {
            logger = Logger.getRootLogger();
        } else {
            logger = Logger.getLogger(name);
        }
        logger.setLevel(level);
        logger.addAppender(appender);
        logger.info("Starting " + logger.getName());
    }
}

