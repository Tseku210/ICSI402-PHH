package com.example.web_dev_book.ch8.services.fedex;

import com.fedex.ws.rate.v10.Address;
import sun.jvm.hotspot.debugger.Address;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class FedexAddress extends Address {

    @Override
    @NotNull
    @Pattern(regexp=".*\\S.*", message="cannot be empty")
    public String getCity() {
        return super.getCity();
    }

    @Override
    @NotNull
    @Pattern(regexp="\\d{5}(-\\d{4})?", message="must be 5 digits or ZIP+4")
    public String getPostalCode() {
        return super.getPostalCode();
    }

    @Override
    @NotNull
    @Pattern(regexp=".*\\S.*", message="cannot be empty")
    public String getStateOrProvinceCode() {
        return super.getStateOrProvinceCode();
    }

    public void setStreetAddress(String street) {
        if (street == null) return;
        BufferedReader reader =
                new BufferedReader(new StringReader(street));
        String line;
        try {
            if (super.streetLines == null) {
                super.streetLines = new ArrayList<String>();
            }
            super.streetLines.clear();
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty())
                    super.streetLines.add(line);
            }
        } catch (IOException ex) {
            Logger.getLogger(FedexAddress.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

    @NotNull
    @Pattern(regexp="(.*\\S.*(\\r\\n)?)+", message="cannot be empty")
    public String getStreetAddress() {
        StringBuilder result = new StringBuilder();
        for (String line : super.getStreetLines()) {
            result.append(String.format("%s%n", line));
        }
        return result.toString();
    }

}

