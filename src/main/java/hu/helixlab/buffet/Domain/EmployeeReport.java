package hu.helixlab.buffet.Domain;

import javax.persistence.Entity;
import java.math.BigInteger;


public class EmployeeReport {



    private String employeeName;
    private Integer employeeId;
    private BigInteger sumPrice;

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public BigInteger getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(BigInteger sumPrice) {
        this.sumPrice = sumPrice;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
}
