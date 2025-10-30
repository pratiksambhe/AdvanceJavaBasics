package com.example.AUg5_SpringProject.ocr;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@RestController
@RequestMapping("/image")
//it is for jpg,png,webp
public class Images {


    //for single format like webp/jpg/jpeg/png
    @GetMapping("/file")//add OCR dependency
    public void readfile(@RequestParam MultipartFile multipartFile) throws IOException, TesseractException {
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");
        tesseract.setLanguage("eng+hin");//for hindi and english both
        Path path = Paths.get("ocr.jpg");//for webp requies two dependencies
        Files.copy(multipartFile.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        String s = tesseract.doOCR(path.toFile());
        System.out.println(s);
    }

    //for any file format of image
    @GetMapping("/allType")
    public void readFiles(@RequestParam MultipartFile multipartFile) throws IOException, TesseractException {
        Tesseract tesseract=new Tesseract();
        tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");
        tesseract.setLanguage("eng");

        BufferedImage bufferedImage = ImageIO.read(multipartFile.getInputStream());
        String s = tesseract.doOCR(bufferedImage);
        System.out.println(s);
    }

}
