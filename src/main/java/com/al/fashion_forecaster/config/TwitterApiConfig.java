package com.al.fashion_forecaster.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "twitter.api")
public class TwitterApiConfig {

    private String bearerToken;
    private String baseUrl;

    // Getter for bearerToken
    public String getBearerToken() {
        return bearerToken;
    }

    // Setter for bearerToken
    public void setBearerToken(String bearerToken) {
        this.bearerToken = bearerToken;
    }

    // Getter for baseUrl
    public String getBaseUrl() {
        return baseUrl;
    }

    // Setter for baseUrl
    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}
