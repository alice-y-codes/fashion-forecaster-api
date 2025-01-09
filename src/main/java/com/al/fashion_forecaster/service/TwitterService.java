package com.al.fashion_forecaster.service;

import com.al.fashion_forecaster.config.TwitterApiConfig;
import com.al.fashion_forecaster.model.Tweet;
import com.al.fashion_forecaster.util.TwitterApiUtil;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.scheduling.annotation.Async;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class TwitterService {

    private final TwitterApiConfig twitterApiConfig;

    // Injecting TwitterApiConfig
    @Autowired
    public TwitterService(TwitterApiConfig twitterApiConfig) {
        this.twitterApiConfig = twitterApiConfig;
    }

    private static final String BASE_URL = "https://api.twitter.com/2/tweets/search/recent?query=";

    // Asynchronous method to fetch tweets, considering pagination
    @Async
    public CompletableFuture<List<Tweet>> fetchTweetsWithPagination(String keyword) {
        List<Tweet> allTweets = new ArrayList<>();
        String nextToken = null;

        String baseUrl = twitterApiConfig.getBaseUrl();
        String bearerToken = twitterApiConfig.getBearerToken();
        String endpoint = "/2/tweets/search/recent";

        do {
            String url = baseUrl + endpoint + "?query=" + keyword + (nextToken != null ? "&next_token=" + nextToken : "");
            RestTemplate restTemplate = new RestTemplate();

            // Prepare headers with Bearer token for authorization
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer " + bearerToken);
            HttpEntity<String> entity = new HttpEntity<>(headers);

            // Send the request
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

            // Parse the response
            List<Tweet> tweets = TwitterApiUtil.parseTweets(response.getBody());
            allTweets.addAll(tweets);

            // Check if there is another page of results
            nextToken = extractNextToken(response.getBody());

        } while (nextToken != null);  // Continue fetching until no next token is available

        return CompletableFuture.completedFuture(allTweets);
    }

    // Helper method to extract next_token from the API response for pagination
    public String extractNextToken(String response) {
        try {
            JsonNode root = new ObjectMapper().readTree(response);
            JsonNode meta = root.path("meta");
            return meta.has("next_token") ? meta.path("next_token").asText() : null;
        } catch (Exception e) {
            return null;
        }
    }
}


