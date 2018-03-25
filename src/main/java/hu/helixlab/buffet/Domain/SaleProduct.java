package hu.helixlab.buffet.Domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;



@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class SaleProduct {
    @Id
    @SequenceGenerator(name="sale_product_id_seq", sequenceName="sale_product_id_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.AUTO, generator="sale_product_id_seq")
    private Integer id;

    @OneToOne
    @JoinColumn(name="product_id")
    private Product product;

    private Integer quantity;


    @ManyToOne
    @JoinColumn(name="sale_id")
    private Sale sale;


    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
