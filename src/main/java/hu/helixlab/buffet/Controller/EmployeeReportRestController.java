package hu.helixlab.buffet.Controller;

import hu.helixlab.buffet.Domain.EmployeeReport;
import hu.helixlab.buffet.Service.EmployeeReportService;
import org.apache.poi.ss.usermodel.Workbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class EmployeeReportRestController {
    @Autowired
    private EmployeeReportService employeeReportService;


    @RequestMapping(value = "/buffet/employeereport", method = RequestMethod.POST )
    @CrossOrigin(origins = "http://localhost")
    public List<EmployeeReport> employeeReport(){
        return employeeReportService.employeeReport();
    }


    @RequestMapping(value ="/buffet/employeereporttofile", method = RequestMethod.POST, produces = "application/octet-stream;charset=UTF-8")
    @CrossOrigin(origins = "http://localhost")
    public void employeeReportToFile(HttpServletResponse response){
        Workbook wb = employeeReportService.saveEmployeeReport();
        try {

            response.addHeader("Content-Disposition", "attachment; filename=\"Dolgozók_riport.xlsx\"");
            wb.write(response.getOutputStream());
            wb.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
