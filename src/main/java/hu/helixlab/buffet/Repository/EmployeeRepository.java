package hu.helixlab.buffet.Repository;

import hu.helixlab.buffet.Domain.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    @Query(value="select * from employee order by employee_name ASC", nativeQuery = true)
    public List<Employee> findAll();
}
