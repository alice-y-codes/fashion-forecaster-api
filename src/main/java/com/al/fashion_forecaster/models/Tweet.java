package com.al.fashion_forecaster.models;

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
}
