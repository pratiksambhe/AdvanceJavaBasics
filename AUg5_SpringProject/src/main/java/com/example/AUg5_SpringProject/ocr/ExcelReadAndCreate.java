package com.example.AUg5_SpringProject.ocr;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/Excel")
public class ExcelReadAndCreate {

    // for Excel we need two dependencies
    @GetMapping("/read")
    public void readExcel(@RequestParam MultipartFile multipartFile){
        try (Workbook workbook = WorkbookFactory.create(multipartFile.getInputStream());)
            {   // Auto detect XLS/XLSX

            Sheet sheet = workbook.getSheetAt(0); // first sheet


            for (Row row : sheet) {
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING -> System.out.print(cell.getStringCellValue() + "\t");
                        case NUMERIC -> {
                            if (DateUtil.isCellDateFormatted(cell)) {
                                System.out.print(cell.getDateCellValue() + "\t");
                            } else {
                                System.out.print(cell.getNumericCellValue() + "\t");
                            }
                        }
                        case BOOLEAN -> System.out.print(cell.getBooleanCellValue() + "\t");
                        case FORMULA -> System.out.print(cell.getCellFormula() + "\t");
                        default -> System.out.print(" \t");
                    }
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //same two dependencies like above
    @GetMapping("/create")
    public void createExcel() {
        String filePath = "C:\\Users\\Sreenivas Bandaru\\Downloads\\AUg5_SpringProject\\employees.xlsx"; // change path as per your system

        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Employees");

            // Header Row
            Row headerRow = sheet.createRow(0);
            String[] headers = {"ID", "Name", "Department", "Salary"};

            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
            }

            // Sample Data
            Object[][] data = {
                    {1, "Pratik", "IT", 50000},
                    {2, "Mahesh", "Mechanical", 45000},
                    {3, "Ravi", "Civil", 40000}
            };

            int rowNum = 1;
            for (Object[] rowData : data) {
                Row row = sheet.createRow(rowNum++);
                for (int i = 0; i < rowData.length; i++) {
                    Cell cell = row.createCell(i);

                    if (rowData[i] instanceof String) {
                        cell.setCellValue((String) rowData[i]);
                    } else if (rowData[i] instanceof Integer) {
                        cell.setCellValue((Integer) rowData[i]);
                    } else if (rowData[i] instanceof Double) {
                        cell.setCellValue((Double) rowData[i]);
                    }
                }
            }

            // Auto-size columns
            for (int i = 0; i < headers.length; i++) {
                sheet.autoSizeColumn(i);
            }

            // Write to File
            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

