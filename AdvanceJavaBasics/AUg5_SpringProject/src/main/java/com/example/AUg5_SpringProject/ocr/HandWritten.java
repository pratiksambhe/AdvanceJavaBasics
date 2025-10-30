package com.example.AUg5_SpringProject.ocr;

import com.google.cloud.vision.v1.*;
import com.google.protobuf.ByteString;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

@RestController
public class HandWritten {
    @PostMapping("/read")
    public String readHandwriting(@RequestParam("file") MultipartFile multipartFile) {
        try {
            // Convert multipart file to ByteString
            ByteString imgBytes = ByteString.readFrom(multipartFile.getInputStream());

            // Build Image object
            Image img = Image.newBuilder().setContent(imgBytes).build();

            // Set feature to detect handwriting / text
            Feature feature = Feature.newBuilder()
                    .setType(Feature.Type.DOCUMENT_TEXT_DETECTION)
                    .build();

            AnnotateImageRequest request = AnnotateImageRequest.newBuilder()
                    .addFeatures(feature)
                    .setImage(img)
                    .build();

            // Call Google Vision API
            try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
                List<AnnotateImageResponse> responses =
                        client.batchAnnotateImages(List.of(request)).getResponsesList();

                StringBuilder resultText = new StringBuilder();

                for (AnnotateImageResponse res : responses) {
                    if (res.hasError()) {
                        return "Error: " + res.getError().getMessage();
                    }
                    resultText.append(res.getFullTextAnnotation().getText());
                }
                return resultText.toString();
            }
        } catch (IOException e) {
            return "Failed to process image: " + e.getMessage();
        }
    }
}
