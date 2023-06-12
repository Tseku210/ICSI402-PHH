package com.example.web_dev_book.ch8.services.fedex;

import com.fedex.ws.rate.v10.Dimensions;

public class RequestDataFedex {

    FedexAddress addressShipper;
    FedexAddress addressRecipient;
    FedexDimensions dimensions;

    public FedexAddress getAddressRecipient() {
        return addressRecipient;
    }

    public void setAddressRecipient(FedexAddress addressRecipient) {
        this.addressRecipient = addressRecipient;
    }

    public FedexAddress getAddressShipper() {
        return addressShipper;
    }

    public void setAddressShipper(FedexAddress addressShipper) {
        this.addressShipper = addressShipper;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public void setDimensions(FedexDimensions dimensions) {
        this.dimensions = dimensions;
    }
}

