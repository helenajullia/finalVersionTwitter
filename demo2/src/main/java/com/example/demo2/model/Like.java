package com.example.demo2.model;

import java.time.LocalDateTime;

public class Like {
    private User liker;
    private LocalDateTime timestamp;

    public Like(User liker) {
        this.liker = liker;
        this.timestamp = LocalDateTime.now();
    }

    public User getLiker() {
        return liker;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
