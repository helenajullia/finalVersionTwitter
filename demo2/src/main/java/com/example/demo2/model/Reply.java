package com.example.demo2.model;

import java.time.LocalDateTime;

public class Reply {
    private String replyId;
    private String content;
    private LocalDateTime timestamp;
    private User user;
    private Post post;
    private Boolean isPublic;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getReplyId() {
        return replyId;
    }

    public void setReplyId(String replyId) {
        this.replyId = replyId;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public Reply(String replyId, String content, LocalDateTime timestamp, User user, Post post, Boolean isPublic) {
        this.replyId = replyId;
        this.content = content;
        this.timestamp = timestamp;
        this.user = user;
        this.post = post;
        this.isPublic=isPublic;
    }

    public Post getPost() {
        return post;
    }
}
