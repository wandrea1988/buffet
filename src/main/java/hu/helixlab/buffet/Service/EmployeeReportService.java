package hu.helixlab.buffet.Service;

import hu.helixlab.buffet.Domain.EmployeeReport;
import hu.helixlab.buffet.Repository.EmployeeReportRepository;
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
public class EmployeeReportService {
    @Autowired
    EmployeeReportRepository employeeReportRepository;




    public List<EmployeeReport> employeeReport(){

        List<Object[]> employeeReportList= employeeReportRepository.employeeReport();


        List<EmployeeReport> employeeReportOutputList = new ArrayList<>();


        for(Object[] ob : employeeReportList){
            EmployeeReport employeeReport= new EmployeeReport();
            employeeReport.setSumPrice((BigInteger) ob[0]);
            employeeReport.setEmployeeName((String) ob[1]);
            employeeReport.setEmployeeId((Integer) ob[2]);

            employeeReportOutputList.add(employeeReport);
        }
        return employeeReportOutputList;
    }

    public Workbook saveEmployeeReport(){
        List<EmployeeReport> reportList = employeeReport();

        Workbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet("Dolgozók Riport");
        int rowNum = 0;
        Row r = sheet.createRow(rowNum++);
        Cell employeeNameCell = r.createCell(0);
        employeeNameCell.setCellValue("Dolgozók neve");

        Cell sumPriceCell = r.createCell(1);
        sumPriceCell.setCellValue("Fogyasztás (Ft)");

        for(EmployeeReport er : reportList){
            Row row = sheet.createRow(rowNum++);
            Cell nameCell = row.createCell(0);
            nameCell.setCellValue(er.getEmployeeName());
            Cell priceCell = row.createCell(1);
            priceCell.setCellValue(er.getSumPrice().intValue());
        } return wb;
    }
}
