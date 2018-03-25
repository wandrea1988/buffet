package hu.helixlab.buffet.Repository;

import hu.helixlab.buffet.Domain.Employee;
import hu.helixlab.buffet.Domain.EmployeeReport;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeReportRepository extends CrudRepository<Employee, Integer> {

    @Query(value="select sum(product_price*quantity), employee.employee_name, employee.id from product \n" +
            "inner join sale_product on product.id=sale_product.product_id inner join sale on sale_product.sale_id=sale.id\n" +
            "inner join employee on sale.employee_id=employee.id \n" +
            "where sale.sale_time>=date_trunc('month', clock_timestamp()) and sale.sale_time<date_trunc('month', clock_timestamp())+interval '1 month'\n" +
            "group by employee.employee_name, employee.id order by employee.employee_name", nativeQuery = true)
    public List<Object[]> employeeReport();
}
