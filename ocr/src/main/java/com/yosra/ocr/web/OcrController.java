package com.yosra.ocr.web;

import com.yosra.ocr.service.OcrService;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class contains all web services exposes to the client.
 *
 * @author yosra fatnassi
 */
@RestController
@RequestMapping("ocr")
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
    @PostMapping(value = "/convert", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<JSONObject> convertImage(@RequestParam("image") String image) {
        LOGGER.info("Requesting to extract text from image ");
        JSONObject result = this.ocrService.extractText(image);
        return ResponseEntity.ok(result);
    }

}
