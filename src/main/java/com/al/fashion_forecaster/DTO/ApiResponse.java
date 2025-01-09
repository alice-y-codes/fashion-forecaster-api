package com.al.fashion_forecaster.DTO;

public class ApiResponse {
    private String status;
    private String message;
    private int savedTweetsCount;

    // Constructor
    public ApiResponse(String status, String message, int savedTweetsCount) {
        this.status = status;
        this.message = message;
        this.savedTweetsCount = savedTweetsCount;
    }

    // Getter for status
    public String getStatus() {
        return status;
    }

    // Setter for status
    public void setStatus(String status) {
        this.status = status;
    }

    // Getter for message
    public String getMessage() {
        return message;
    }

    // Setter for message
    public void setMessage(String message) {
        this.message = message;
    }

    // Getter for savedTweetsCount
    public int getSavedTweetsCount() {
        return savedTweetsCount;
    }

    // Setter for savedTweetsCount
    public void setSavedTweetsCount(int savedTweetsCount) {
        this.savedTweetsCount = savedTweetsCount;
    }
}
