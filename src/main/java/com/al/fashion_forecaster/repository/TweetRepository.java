package com.al.fashion_forecaster.repository;

import com.al.fashion_forecaster.model.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, String> {
}
