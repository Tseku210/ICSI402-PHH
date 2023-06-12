
package com.example.web_dev_book.ch7.accountLogin;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import shared.HibernateHelper;
import shared.HelperBaseCh6;
import shared.ButtonMethod;

public class ControllerHelper extends HelperBaseCh6 {
  
  protected RequestDataAccount data = new RequestDataAccount();
  
  public ControllerHelper(
            HttpServlet servlet,
            HttpServletRequest request,
            HttpServletResponse response) {
        super(servlet, request, response);
  }
  
  static public void initHibernate(boolean create)
  {
    if (create) {
      HibernateHelper
          .createTable(RequestDataAccount.class);
    }
    HibernateHelper
        .initSessionFactory(RequestDataAccount.class);
  }
  
  public Object getData() {
    return data;
  }
  
  public void copyFromSession(Object sessionHelper) {
    if (sessionHelper.getClass() == this.getClass()) {
      data = ((ControllerHelper)sessionHelper).data;
    }
  }
  
  public String jspLocation(String page) {
    return "/WEB-INF/classes/ch7/accountLogin/" + page;
  }
  
  @ButtonMethod(isDefault=true)
  public String getMethod() {
    return jspLocation("Login.jsp");
  }
  
  @ButtonMethod(buttonName="loginButton")
  public String loginMethod() {
    String address;
    fillBeanFromRequest(data);
    setErrors(data);
    if (isValidProperty("accountNumber")) {
      Object dataPersistent = 
        HibernateHelper.getFirstMatch(data, 
          "accountNumber", data.getAccountNumber());
      if (dataPersistent != null) {
        data = (RequestDataAccount)dataPersistent;
      }
      clearErrors();
      address = "Edit.jsp";
    } else {
      address = "Login.jsp";
    }
    return jspLocation(address);
  }
  
  @ButtonMethod(buttonName="newUserButton")
  public String newUserMethod() {
    return jspLocation("Login.jsp");
  }
  
  @ButtonMethod(buttonName="editButton")
  public String editMethod() {
    return jspLocation("Edit.jsp");
  }
  
  @ButtonMethod(buttonName="confirmButton")
  public String confirmMethod() {
    //Create new data and populate from the query string
    fillBeanFromRequest(data);
    //The next JSP address depends on the validity of the data.
    String address;
    if (isValid(data)) {
      address = "Confirm.jsp";
    } else {
      address = "Edit.jsp";
    }
    return jspLocation(address);
  }
  
  @ButtonMethod(buttonName="processButton")
  public String processMethod() {
    if (!isValid(data)) {
      return jspLocation("Expired.jsp");
    }
    HibernateHelper.updateDB(data);
    List list = HibernateHelper.
        getListData(RequestDataAccount.class);
    request.setAttribute("database", list);
    return jspLocation("Process.jsp");
  }
  
@Override
public void doGet() 
  throws ServletException, java.io.IOException 
{
  addHelperToSession("helper", SessionData.IGNORE);

  //Edit.jsp is the only page that will be displayed from a GET request.
  String address = getMethod();

  request.getRequestDispatcher(address)
      .forward(request, response);    
  }
  
@Override
public void doPost() 
  throws ServletException, java.io.IOException 
{    
  addHelperToSession("helper", SessionData.READ);

  String address = executeButtonMethod();

  request.getRequestDispatcher(address)
      .forward(request, response);
  } 
}
