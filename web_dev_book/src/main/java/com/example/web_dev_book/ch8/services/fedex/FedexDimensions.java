package com.example.web_dev_book.ch8.services.fedex;

import com.fedex.ws.rate.v10.Dimensions;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


public class FedexDimensions extends Dimensions {

    @Override
    @Min(1)
    @Max(200)
    public BigInteger getHeight() {
        return super.getHeight();
    }

    @Override
    @Min(1)
    @Max(200)
    public BigInteger getLength() {
        return super.getLength();
    }

    @Override
    @Min(1)
    @Max(200)
    public BigInteger getWidth() {
        return super.getWidth();
    }

    protected BigDecimal weight;

    @Min(1)
    @Max(200)
    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

}

