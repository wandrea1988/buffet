package hu.helixlab.buffet.Domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Sale {
    @Id
    @SequenceGenerator(name="sale_id_seq", sequenceName="sale_id_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.AUTO, generator="sale_id_seq")

    private Integer id;
    private Timestamp saleTime;

    @OneToOne
    @JoinColumn(name="employee_id")
    private Employee employee;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "sale")
    @JsonIgnoreProperties("sale")
    private Set<SaleProduct> saleProducts= new HashSet<>();

    public Set<SaleProduct> getSaleProducts() {
        return saleProducts;
    }

    public void setSaleProducts(Set<SaleProduct> saleProducts) {
        this.saleProducts = saleProducts;
    }

    public void addSaleProduct (SaleProduct saleProduct){
        this.saleProducts.add(saleProduct);
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getSaleTime() {
        return saleTime;
    }

    public void setSaleTime(Timestamp saleTime) {
        this.saleTime = saleTime;
    }
}
