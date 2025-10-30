package com.example.AUg5_SpringProject.ocr;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@RestController
public class ControllerOCR {
    @Autowired
    private ServiceOCR serviceOCR;

    @GetMapping("/test")
    public void testOCR(@RequestParam MultipartFile multipartFile) throws TesseractException, IOException {
        serviceOCR.testOCR(multipartFile);
    }


    //advance way to handel the multipart files and for pdf add dependency
    @GetMapping("/test2")
    public void advwayOCR(@RequestParam MultipartFile multipartFile) throws IOException, TesseractException {
        serviceOCR.advwayOCR(multipartFile);
    }


    @GetMapping("/chequeOCR")
    public String readCheque(@RequestParam MultipartFile multipartFile) throws IOException, TesseractException {
        // Load image from MultipartFile
        BufferedImage img = ImageIO.read(multipartFile.getInputStream());

        // ✅ Step 1: Convert to Grayscale
        BufferedImage gray = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        Graphics g = gray.getGraphics();
        g.drawImage(img, 0, 0, null);
        g.dispose();

        // ✅ Step 2: Thresholding (Binary Image)
        BufferedImage binary = new BufferedImage(gray.getWidth(), gray.getHeight(), BufferedImage.TYPE_BYTE_BINARY);
        Graphics2D g2d = binary.createGraphics();
        g2d.drawImage(gray, 0, 0, null);
        g2d.dispose();

        // ✅ Step 3: Noise Removal (Median Filter)
        binary = applyMedianFilter(binary);

        // (Optional) Save processed image to verify preprocessing
        File processed = new File("processed_cheque.png");
        ImageIO.write(binary, "png", processed);

        // ✅ Step 4: OCR with Tesseract
        ITesseract tesseract = new Tesseract();
        tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata"); // path to tessdata
        tesseract.setLanguage("eng");
        tesseract.setOcrEngineMode(1); // LSTM Only
        tesseract.setPageSegMode(6);   // Assume block of text
        String s = tesseract.doOCR(binary);
        System.out.println(s);

        return s; // Return extracted text
    }

    // 🔧 Utility: Median Filter (noise removal)
    private BufferedImage applyMedianFilter(BufferedImage img) {
        int radius = 1;
        int size = 2 * radius + 1;
        BufferedImage output = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());

        for (int y = radius; y < img.getHeight() - radius; y++) {
            for (int x = radius; x < img.getWidth() - radius; x++) {
                int[] pixels = new int[size * size];
                int k = 0;

                for (int dy = -radius; dy <= radius; dy++) {
                    for (int dx = -radius; dx <= radius; dx++) {
                        pixels[k++] = img.getRGB(x + dx, y + dy) & 0xFF;
                    }
                }

                java.util.Arrays.sort(pixels);
                int median = pixels[pixels.length / 2];
                int rgb = (median << 16) | (median << 8) | median;
                output.setRGB(x, y, 0xFF000000 | rgb);
            }
        }
        return output;
    }


}
