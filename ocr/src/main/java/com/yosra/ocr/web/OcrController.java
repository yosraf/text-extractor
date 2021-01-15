package com.yosra.ocr.web;

import com.yosra.ocr.service.OcrService;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * This class contains all web services exposes to the client.
 *
 * @author yosra fatnassi
 */
@RestController
@RequestMapping("ocr")
@CrossOrigin("http://localhost:4200")
public class OcrController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OcrController.class);
    private final OcrService ocrService;

    /**
     * Instantiate the OcrController class.
     *
     * @param ocrService the ocrService that contains the logic
     */
    public OcrController(OcrService ocrService) {
        this.ocrService = ocrService;
    }

    /*
     * This method allow to extract text from image or file.
     * @param image the based64 image or file
     * @return the extracted text
     *
     * */
    @PostMapping(value = "/convert")
    public ResponseEntity<JSONObject> convertImage(@RequestBody String image) {
        LOGGER.info("Requesting to extract text from image ");
        JSONObject result = this.ocrService.extractText(image);
        return ResponseEntity.ok(result);
    }

}
