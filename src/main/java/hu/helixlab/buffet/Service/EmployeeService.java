package hu.helixlab.buffet.Service;

import hu.helixlab.buffet.Domain.Employee;
import hu.helixlab.buffet.Repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService {
@Autowired
    private EmployeeRepository employeeRepository;

    public Iterable<Employee> findAllEmployee () {
        return employeeRepository.findAll();
    }
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployeeById (int id, Employee newEmployee){
       Employee oldEmployee = employeeRepository.findOne(id);

        oldEmployee.setEmployeeName(newEmployee.getEmployeeName() );
        return employeeRepository.save(oldEmployee);
    }

}
