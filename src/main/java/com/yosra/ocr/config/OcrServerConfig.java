package com.yosra.ocr.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OcrServerConfig {

    @Value("${ocr.api.key}")
    private String apiKey;
    @Value("${ocr.api.url}")
    private String apiUrl;

    /**
     * Gets the api key.
     *
     * @return {@code String} the api key
     */
    public String getApiKey() {
        return apiKey;
    }

    /**
     * Sets the api key
     *
     * @param apiKey the api key
     */
    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    /**
     * Gets the api url.
     *
     * @return {@code String} the api url
     */
    public String getApiUrl() {
        return apiUrl;
    }

    /**
     * Sets the api url
     *
     * @param apiUrl the api url
     */
    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }
}
