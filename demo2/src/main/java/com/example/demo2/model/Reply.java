package com.example.demo2.model;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public class Reply {
    private String replyId;
    private String content;
    private LocalDateTime timestamp;
    private String username;
    private String postId;

    private Post post;
    private Boolean isPublic;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public void setPostId(String postId) {
        this.postId = postId;
    }
    public String getPostId() {
        return postId;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public Post getPost() {
        return post;
    }
    public void setPost(Post post) {
        this.post = post;
    }
    public Reply(String replyId, String content, LocalDateTime timestamp, String username, String postId, Post post, Boolean isPublic) {
        this.replyId = replyId;
        this.content = content;
        this.timestamp = timestamp;
        this.username = username;
        this.postId = postId;
        this.post = post;
        this.isPublic = isPublic;
    }
}
