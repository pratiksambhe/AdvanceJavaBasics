package com.example.AUg5_SpringProject.ocr;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Row;
import com.lowagie.text.pdf.PdfWriter;
import net.sourceforge.tess4j.Tesseract;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import technology.tabula.ObjectExtractor;
import technology.tabula.Page;
import technology.tabula.RectangularTextContainer;
import technology.tabula.Table;
import technology.tabula.extractors.SpreadsheetExtractionAlgorithm;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
public class PdfReadCreate {

    //add pdfbox dependency
    @GetMapping("/readPdf")
    public void pdfRead(@RequestParam MultipartFile multipartFile) {
        try (PDDocument load = PDDocument.load(multipartFile.getInputStream())) {
            String text = new PDFTextStripper().getText(load);
            System.out.println(text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    //reading tables need Tabula dependency
    @GetMapping("/readPdfTables")
    public void resdPdfTable(@RequestParam MultipartFile multipartFile) {
        StringBuilder builder = new StringBuilder();
        try (PDDocument load = PDDocument.load(multipartFile.getInputStream());) {
            ObjectExtractor objectExtractor = new ObjectExtractor(load);
            Page extract = objectExtractor.extract(1);
            SpreadsheetExtractionAlgorithm algorithm = new SpreadsheetExtractionAlgorithm();
            List<Table> table = algorithm.extract(extract);
            for(Table table1:table){
                for( List<RectangularTextContainer> l:table1.getRows()){
                    for (RectangularTextContainer cell:l){
                        builder.append(cell.getText()).append("\t");
                    }
                    builder.append("\n");
                }
                System.out.println(builder);
            }


        } catch (RuntimeException |IOException e) {
            throw new RuntimeException(e);
        }
    }

    //create pdf file and add openPdf Dependency
    @GetMapping("/createPdf")
    public void createPdf() throws FileNotFoundException {
        Document document=new Document();
        String s="C:\\Users\\Sreenivas Bandaru\\Downloads\\AUg5_SpringProject\\ocr.pdf";
        FileOutputStream fileOutputStream=new FileOutputStream(s);
        PdfWriter.getInstance(document,fileOutputStream);
        document.open();
        document.add(new Paragraph(".khlire"));
        document.close();

    }


}
