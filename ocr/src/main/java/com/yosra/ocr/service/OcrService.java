package com.yosra.ocr.service;

import com.yosra.ocr.config.OcrServerConfig;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;

/**
 * This class contains the business logic that allow client to convert image to text
 *
 * @author yosra fatnassi
 */
@Service
public class OcrService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OcrService.class);
    private final OcrServerConfig ocrServerConfig;
    private Object result1;

    /**
     * Instantiate the ocr service.
     *
     * @param ocrServerConfig the server config
     */
    public OcrService(OcrServerConfig ocrServerConfig) {
        this.ocrServerConfig = ocrServerConfig;
    }

    /**
     * This method allow to send http request to the ocr api and extract
     * the text from response.
     *
     * @param image base64 image or file
     * @return the extracted text
     */
    public JSONObject extractText(String image) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("apikey", ocrServerConfig.getApiKey());
        headers.setAccept(Arrays.asList(MediaType.MULTIPART_FORM_DATA));
        MultiValueMap<String, String> body
                = new LinkedMultiValueMap<>();

        body.add("base64Image",
                image
        );
        HttpEntity<MultipartFile> entity = new HttpEntity(body, headers);
        LOGGER.info("Calling the ocr api");
        String result = restTemplate.exchange(
                ocrServerConfig.getApiUrl(), HttpMethod.POST, entity, String.class).getBody();

        Object obj = JSONValue.parse(result);
        JSONObject jsonObject = (JSONObject) obj;
        return jsonObject;
    }

}
