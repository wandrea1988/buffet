package hu.helixlab.buffet.Domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;



@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {
    @Id
    @SequenceGenerator(name="product_id_seq", sequenceName="product_id_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.AUTO, generator="product_id_seq")

    private Integer id;
    private String productName;
    private Integer productPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }
}
