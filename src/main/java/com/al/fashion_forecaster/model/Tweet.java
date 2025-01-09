package com.al.fashion_forecaster.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Tweet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String text;
    private int likeCount;
    private int retweetCount;
    private LocalDateTime fetchedAt;

    // Getter for id
    public long getId() {
        return id;
    }

    // Setter for id
    public void setId(long id) {
        this.id = id;
    }

    // Getter for text
    public String getText() {
        return text;
    }

    // Setter for text
    public void setText(String text) {
        this.text = text;
    }

    // Getter for likeCount
    public int getLikeCount() {
        return likeCount;
    }

    // Setter for likeCount
    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    // Getter for retweetCount
    public int getRetweetCount() {
        return retweetCount;
    }

    // Setter for retweetCount
    public void setRetweetCount(int retweetCount) {
        this.retweetCount = retweetCount;
    }

    // Getter for fetchedAt
    public LocalDateTime getFetchedAt() {
        return fetchedAt;
    }

    // Setter for fetchedAt
    public void setFetchedAt(LocalDateTime fetchedAt) {
        this.fetchedAt = fetchedAt;
    }
}
