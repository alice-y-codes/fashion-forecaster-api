package com.al.fashion_forecaster.repositories;

import com.al.fashion_forecaster.models.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, String> {
}
