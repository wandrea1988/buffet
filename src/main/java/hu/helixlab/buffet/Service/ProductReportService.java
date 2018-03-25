package hu.helixlab.buffet.Service;

import hu.helixlab.buffet.Domain.ProductReport;
import hu.helixlab.buffet.Repository.ProductReportRepository;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductReportService {

    @Autowired
    private ProductReportRepository productReportRepository;

    public List<ProductReport> productReport(){

        List<Object[]> productReportList= productReportRepository.productReport();


        List<ProductReport> productReportOutputList = new ArrayList<>();


        for(Object[] ob : productReportList){
            ProductReport productReport= new ProductReport();
            productReport.setSumQuantity ((BigInteger) ob[0]);
            productReport.setProductName((String) ob[1]);

            productReportOutputList.add(productReport);
        }
        return productReportOutputList;
    }

    public Workbook saveProductReport(){
        List<ProductReport> reportList = productReport();

        Workbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet("Termékek Riport");
        int rowNum = 0;
        Row r = sheet.createRow(rowNum++);
        Cell employeeNameCell = r.createCell(0);
        employeeNameCell.setCellValue("Termékek neve");

        Cell sumPriceCell = r.createCell(1);
        sumPriceCell.setCellValue("Fogyás mennyisége (db)");

        for(ProductReport pr : reportList){
            Row row = sheet.createRow(rowNum++);
            Cell nameCell = row.createCell(0);
            nameCell.setCellValue(pr.getProductName());
            Cell quantityCell = row.createCell(1);
            quantityCell.setCellValue(pr.getSumQuantity().intValue());
        } return wb;
    }
}
