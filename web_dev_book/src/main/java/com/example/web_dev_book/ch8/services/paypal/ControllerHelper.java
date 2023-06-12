package com.example.web_dev_book.ch8.services.paypal;

import com.nvp.codegenerator.ECDoExpressCheckout;
import com.nvp.codegenerator.ECGetExpressCheckout;
import com.nvp.codegenerator.ECSetExpressCheckout;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import shared.HibernateHelper;
import shared.ButtonMethod;

public class ControllerHelper extends ControllerHelper {

    public ControllerHelper(
            HttpServlet servlet,
            HttpServletRequest request,
            HttpServletResponse response) {
        super(servlet, request, response);
    }

    static public void initHibernate(HttpServlet servlet) {
        HibernateHelper.initSessionFactory(CatalogueItem.class);
    }

    public String jspLocation(String page) {
        return "/WEB-INF/classes/ch7/catalogue/" + page;
    }

    @ButtonMethod(buttonName = "processCart")
    public String methodProcess() {
        cart.setTotal(0);
        cart.setCount(0);
        for (CatalogueItem anItem : cart.getItems()) {
            cart.addTotal(anItem.getPrice());
            cart.incrCount();
        }



        return jspLocation("paypal/ProcessCart.jsp");
    }

    @ButtonMethod(buttonName = "buttonPaypal")
    public String methodPaypal() {
        cart.setTotal(0);
        cart.setCount(0);
        for (CatalogueItem anItem : cart.getItems()) {
            cart.addTotal(anItem.getPrice());
            cart.incrCount();
        }

        ECSetExpressCheckout checkout = new ECSetExpressCheckout();
        Map map = checkout.ECSetExpressCheckoutCode(
                "http://localhost:8086/book/ch7/catalogue/paypal/Controller?buttonPaypalReturn=Return",
                "http://localhost:8086/book/ch7/catalogue/paypal/Controller?buttonPaypalCancel=Cancel",
                "100.00",
                "Sale",
                "USD");


        for (Object obj : map.keySet()) {
            System.out.format("%s = %s%n", obj.toString(), map.get(obj).toString());
        }

        try {
            //
            //        ECGetExpressCheckout details = new ECGetExpressCheckout();
            //        details.ECGetExpressCheckoutCode((String)map.get("TOKEN"));

            response.sendRedirect(String.format("%s%s",
                    "https://www.sandbox.paypal.com/webscr?cmd=_express-checkout&token=",
                    map.get("TOKEN")));
        } catch (IOException ex) {
            Logger.getLogger(ControllerHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @ButtonMethod(buttonName = "buttonPaypalReturn")
    public String methodPaypalReturn() {

        ECGetExpressCheckout details = new ECGetExpressCheckout();
        String result = details.ECGetExpressCheckoutCode(request.getParameter("token"));
        System.out.println(result);
        ECDoExpressCheckout trx = new ECDoExpressCheckout();
        String trxResult = trx.ECDoExpressCheckoutCode(request.getParameter("token"),
                request.getParameter("PayerID"), "100.00", "Sale", "USD");

        System.out.println(trxResult);
        return jspLocation("paypal/PaypalReturn.jsp");
    }

    @Override
    public void doGet()
            throws IOException, ServletException {
        addHelperToSession("helper", SessionData.READ);

        //BrowseLoop.jsp is only page that a GET request will see.
        String address = executeButtonMethod();

        if (address != null && !address.isEmpty())
            request.getRequestDispatcher(address).forward(request, response);
    }

    @Override
    public void doPost()
            throws ServletException, IOException {
        addHelperToSession("helper", SessionData.READ);

        String address = executeButtonMethod();

        if (address != null && !address.isEmpty())
            request.getRequestDispatcher(address).forward(request, response);
    }
}

