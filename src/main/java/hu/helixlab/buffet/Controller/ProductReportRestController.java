package hu.helixlab.buffet.Controller;

import hu.helixlab.buffet.Domain.ProductReport;
import hu.helixlab.buffet.Service.ProductReportService;
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
public class ProductReportRestController {
    @Autowired
    ProductReportService productReportService;


    @RequestMapping(value = "/buffet/productreport", method = RequestMethod.POST )
    @CrossOrigin(origins = "http://localhost")
    public List<ProductReport> productReport(){
        return productReportService.productReport();
    }

    @RequestMapping(value ="/buffet/productreporttofile", method = RequestMethod.POST, produces = "application/octet-stream;charset=UTF-8")
    @CrossOrigin(origins = "http://localhost")
    public void productReportToFile(HttpServletResponse response){
        Workbook wb = productReportService.saveProductReport();
        try {

            response.addHeader("Content-Disposition", "attachment; filename=\"Termékek_riport.xlsx\"");
            wb.write(response.getOutputStream());
            wb.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
