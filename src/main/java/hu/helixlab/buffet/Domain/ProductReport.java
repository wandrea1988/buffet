package hu.helixlab.buffet.Domain;

import java.math.BigInteger;


public class ProductReport {

    private String productName;

    private BigInteger sumQuantity;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigInteger getSumQuantity() {
        return sumQuantity;
    }

    public void setSumQuantity(BigInteger sumQuantity) {
        this.sumQuantity = sumQuantity;
    }
}
