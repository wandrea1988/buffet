package hu.helixlab.buffet.Controller;

import hu.helixlab.buffet.Domain.Employee;
import hu.helixlab.buffet.Service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeRestController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/buffet/employee/all", method = RequestMethod.GET )
    @CrossOrigin(origins = "http://localhost")
    public Iterable<Employee> findAll(){

        return  employeeService.findAllEmployee();
    }

    @RequestMapping (value="/buffet/employee", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost")

    public Employee createEmployee(@RequestBody Employee employee) {


        return employeeService.save(employee);
    }

    @RequestMapping (value = "buffet/employee/{id}", method= RequestMethod.PUT)
    @CrossOrigin(origins = "http://localhost")
    public Employee updateEmployeeById(@PathVariable ("id") int id, @RequestBody Employee employee){
        return employeeService.updateEmployeeById(id, employee);
    }


}
