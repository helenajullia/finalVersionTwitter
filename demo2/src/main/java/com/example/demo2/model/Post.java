package com.example.demo2.model;

import com.example.demo2.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Post {
    private String id;
    private String content;
    private String username;
    private LocalDateTime timestamp;
   // private User user;
    private List<String> likes;

    //private Post post;
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Post(String id, String content, String username, LocalDateTime timestamp, User user, List<String> likes) {
        this.id=id;
        this.content = content;
        this.username = username;
        this.timestamp = timestamp;
        //this.user=user;
        //this.likes = new ArrayList<>();
        this.likes = likes;
    }

    /*public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }*/
    public List<String> getLikes() {
        return likes;
    }
    public void setLikes(List<String> likes) {
        this.likes = likes;
    }

    /*public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }*/
}
