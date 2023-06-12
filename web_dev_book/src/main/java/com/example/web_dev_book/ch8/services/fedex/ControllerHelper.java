package com.example.web_dev_book.ch8.services.fedex;


import com.example.web_dev_book.shared.ButtonMethod;
import com.example.web_dev_book.shared.HelperBaseCh5;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ControllerHelper extends HelperBaseCh5 {

    private RequestDataFedex data =
            new RequestDataFedex();

    public ControllerHelper(
            HttpServlet servlet,
            HttpServletRequest request,
            HttpServletResponse response) {
        super(servlet, request, response);
        data.addressShipper = new FedexAddress();
        data.addressRecipient = new FedexAddress();
        data.dimensions = new FedexDimensions();
    }

    public Object getData() {
        return data;
    }

    public void copyFromSession(Object sessionHelper) {
        if (sessionHelper.getClass() == this.getClass()) {
            data = ((ControllerHelper) sessionHelper).data;
        }
    }

    protected String jspLocation(String page) {
        return "/WEB-INF/classes/ch8/services/fedex/"
                + page;
    }

    @ButtonMethod(buttonName = "shipperButton", isDefault = true)
    public String shipperMethod() {
        return jspLocation("ShipperAddress.jsp");
    }

    @ButtonMethod(buttonName = "recipientButton")
    public String recipientMethod() {
        //Populate from the query string
        fillBeanFromRequest(data.addressShipper);
        //The next JSP address depends on the validity of the data.
        String address;
        if (isValid(data.addressShipper)) {
            address = jspLocation("RecipientAddress.jsp");
        } else {
            address = jspLocation("ShipperAddress.jsp");
        }
        return address;
    }

    @ButtonMethod(buttonName = "packageButton")
    public String packageMethod() {
        //Populate from the query string
        fillBeanFromRequest(data.addressRecipient);
        //fillBeanFromRequest(data);
        //The next JSP address depends on the validity of the data.
        String address;
        if (isValid(data.addressRecipient)) {
            address = jspLocation("PackageInfo.jsp");
        } else {
            address = jspLocation("RecipientAddress.jsp");
        }
        return address;
    }

    public void processMethodFedex() {
        try {
            RateRequest rateRequest = null;
            RateService service = new RateService();
            RatePortType port = service.getRateServicePort();
            // TODO process result here
            RateReply result = port.getRates(rateRequest);
            System.out.println("Result = " + result);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @ButtonMethod(buttonName = "processButton")
    public String processMethod() {
        //Populate from the query string
        fillBeanFromRequest(data.dimensions);
        //fillBeanFromRequest(data);
        //The next JSP address depends on the validity of the data.
        String address;

        if (isValid(data.dimensions)) {
            try {
                RateRequest rateRequest = getFedexRequest();
                RateService service = new RateService();
                RatePortType port = service.getRateServicePort();
                // TODO process result here
                RateReply result = port.getRates(rateRequest);
                request.setAttribute(
                        "fedexResult", result.getRateReplyDetails());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            address = jspLocation("Process.jsp");
        } else {
            address = jspLocation("PackageInfo.jsp");
        }
        return address;
    }

    private static final Properties credentials = new Properties();

    static {
        try {
            credentials.load(
                    ControllerHelper.class.getClassLoader().
                            getResourceAsStream("fedex.properties"));
        } catch (IOException ex) {
            System.out.format("Could not open fedex properties: %s%n%s%n",
                    ex.getMessage(), ex.getStackTrace());
        }
    }

    protected RateRequest getFedexRequest() {
        RateRequest info = new RateRequest();

        info.setClientDetail(new ClientDetail());
        info.getClientDetail().
                setAccountNumber(credentials.getProperty("accountNumber"));
        info.getClientDetail().
                setMeterNumber(credentials.getProperty("meterNumber"));

        info.setWebAuthenticationDetail(new WebAuthenticationDetail());
        info.getWebAuthenticationDetail().
                setUserCredential(new WebAuthenticationCredential());
        info.getWebAuthenticationDetail().getUserCredential().
                setKey(credentials.getProperty("key"));
        info.getWebAuthenticationDetail().getUserCredential().
                setPassword(credentials.getProperty("password"));

        info.setVersion(new VersionId());
        info.getVersion().setServiceId("crs");
        info.getVersion().setMajor(10);
        info.getVersion().setIntermediate(0);
        info.getVersion().setMinor(0);

        RequestedPackageLineItem lineItem = new RequestedPackageLineItem();
        lineItem.setGroupPackageCount(new BigInteger("1"));
        lineItem.setWeight(new Weight());
        lineItem.getWeight().setUnits(WeightUnits.LB);
        lineItem.getWeight().setValue(data.dimensions.getWeight());

        lineItem.setDimensions(data.getDimensions());
        lineItem.getDimensions().setUnits(LinearUnits.IN);

        RequestedShipment shipment = new RequestedShipment();

        XMLGregorianCalendar today = null;
        try {
            today = DatatypeFactory.newInstance().newXMLGregorianCalendar(
                    new GregorianCalendar());
        } catch (DatatypeConfigurationException e) {
            System.out.println(e.getStackTrace());
        }
        shipment.setShipTimestamp(today);

        shipment.setShipper(new Party());
        shipment.getShipper().
                setAddress((Address) data.addressShipper);
        shipment.getShipper().getAddress().setCountryCode("US");
        shipment.setRecipient(new Party());
        shipment.getRecipient().
                setAddress((Address) data.addressRecipient);
        shipment.getRecipient().getAddress().setCountryCode("US");

        shipment.getRequestedPackageLineItems().add(lineItem);
        shipment.setPackageCount(new BigInteger("1"));
        shipment.setServiceType(ServiceType.FEDEX_GROUND);

        info.setRequestedShipment(shipment);

        return info;
    }

    @Override
    public void doGet()
            throws ServletException, java.io.IOException {
        //Call the method with false to place a new helper in the session
        addHelperToSession("helper", SessionData.READ);

        String address = executeButtonMethod();

        request.getRequestDispatcher(address).forward(request, response);
    }

    @Override
    public void doPost()
            throws ServletException, java.io.IOException {
        //Call the method with false to place a new helper in the session
        addHelperToSession("helper", SessionData.READ);

        String address = executeButtonMethod();

        request.getRequestDispatcher(address).forward(request, response);
    }
}

