package com.al.fashion_forecaster.service;

import com.al.fashion_forecaster.model.Tweet;
import com.al.fashion_forecaster.repository.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService {

    private final TweetRepository tweetRepository;

    @Autowired
    public DataService(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    public void saveTweets(List<Tweet> tweets) {
        tweetRepository.saveAll(tweets);
    }
}


