package com.al.fashion_forecaster.controllers;

import com.al.fashion_forecaster.DTO.ApiResponse;
import com.al.fashion_forecaster.service.DataService;
import com.al.fashion_forecaster.service.TwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/twitter")
public class TwitterController {

    private final TwitterService twitterService;
    private final DataService dataService;

    // Constructor Injection for better practice
    @Autowired
    public TwitterController(TwitterService twitterService, DataService dataService) {
        this.twitterService = twitterService;
        this.dataService = dataService;
    }

    // Endpoint to fetch tweets by keyword, save them, and return structured response
    @GetMapping(value = "/fetch", produces = "application/json")
    public CompletableFuture<ResponseEntity<ApiResponse>> fetchAndSave(@RequestParam String keyword) {
        // Step 1: Asynchronously fetch tweets (handles pagination internally)
        return twitterService.fetchTweetsWithPagination(keyword)
                .thenApply(tweets -> {
                    // Step 2: Save the tweets using DataService
                    dataService.saveTweets(tweets);

                    // Step 3: Return a structured response
                    ApiResponse response = new ApiResponse("success", "Tweets saved successfully!", tweets.size());
                    return ResponseEntity.ok(response);
                })
                .exceptionally(ex -> {
                    // Handle any errors that occur during the process
                    ApiResponse errorResponse = new ApiResponse("error", "Failed to fetch and save tweets: " + ex.getMessage(), 0);
                    return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
                });
    }
}
