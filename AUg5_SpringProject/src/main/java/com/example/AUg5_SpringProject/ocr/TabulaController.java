//package com.example.AUg5_SpringProject.ocr;
//
//
//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.text.PDFTextStripper;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//import technology.tabula.*;
//import technology.tabula.extractors.BasicExtractionAlgorithm;
//import technology.tabula.extractors.SpreadsheetExtractionAlgorithm;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//@RestController
//public class TabulaController {
//
//
//    @GetMapping("/tabula")
//    public void readPdf(@RequestParam MultipartFile multipartFile)
//    {
////        try(InputStream inputStream=multipartFile.getInputStream())
////        {
////            PDDocument pdDocument=PDDocument.load(inputStream);
////            PDFTextStripper pdfTextStripper=new PDFTextStripper();
////            String text = pdfTextStripper.getText(pdDocument);
////            System.out.println(text);
////        }
////        catch (IOException i)
////        {
////            throw new RuntimeException();
////        }
//
//        try(PDDocument pdDocument=PDDocument.load(multipartFile.getInputStream()))
//        {
//            ObjectExtractor objectExtractor=new ObjectExtractor(pdDocument);
//            PageIterator extract = objectExtractor.extract();
//                SpreadsheetExtractionAlgorithm bea=new SpreadsheetExtractionAlgorithm();
//            while(extract.hasNext())
//            {
//                Page next = extract.next();
//                List<Table> extract1 = bea.extract(next);
//                for(Table table:extract1)
//                {
//                    RectangularTextContainer cell1 = table.getCell(0, 0);
//                    System.out.println(cell1.getText());
//                    List<List<RectangularTextContainer>> rows = table.getRows();
//                    for(List<RectangularTextContainer>list:rows)
//                    {
//                        StringBuilder stringBuilder=new StringBuilder();
//                        for(RectangularTextContainer cell:list)
//                        {
//                            String text = cell.getText();
//                            if(text!=null)
//                            {
//                                text=text.trim();
//                                stringBuilder.append(text);
//                            }
//                        }
//                        System.out.println(stringBuilder.toString().trim());
//                    }
//                }
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public void reading(MultipartFile multipartFile)
//    {
//        try(InputStream inputStream=multipartFile.getInputStream())
//        {
//            Workbook workbook=new XSSFWorkbook(inputStream);
//            Sheet sheetAt = workbook.getSheetAt(0);
//            List<String>list=new ArrayList<>();
//            Iterator<Row> iterator = sheetAt.iterator();
//            while(iterator.hasNext())
//            {
//                Row next = iterator.next();
//                org.apache.poi.ss.usermodel.Cell cell = next.getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
//                list.add(cell.getStringCellValue());
//            }
//
//            while(iterator.hasNext())
//            {
//                Row next = iterator.next();
//
//                for(int i=0;i<list.size();i++)
//                {
//                    org.apache.poi.ss.usermodel.Cell cell = next.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
//
//                    if(cell!=null)
//                    {
//                        switch (cell.getCellType())
//                        {
//                            case STRING ->
//                            case NUMERIC ->
//                        }
//                    }
//                }
//            }
//            for(Row row:sheetAt)
//            {
//                org.apache.poi.ss.usermodel.Cell cell = row.getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
//                list.add(cell.getStringCellValue());
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
