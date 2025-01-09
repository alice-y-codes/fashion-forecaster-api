package com.al.fashion_forecaster.util;

import com.al.fashion_forecaster.model.Tweet;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class TwitterApiUtil {

    public static List<Tweet> parseTweets(String responseBody) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            // Assuming 'data' is the key that holds the list of tweets
            JsonNode root = mapper.readTree(responseBody);
            JsonNode dataNode = root.path("data");

            // Parse data into an array of Tweet objects
            return mapper.readValue(dataNode.toString(), mapper.getTypeFactory().constructCollectionType(List.class, Tweet.class));

        } catch (IOException e) {
            throw new RuntimeException("Failed to parse Twitter response", e);
        }
    }
}
