package com.example.demo2.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
@Entity
@Table(name="posts")
public class Post {
    @Id
    @Column(name="id",nullable = false,unique = true)
    private Long id;
    @Column(name="timestamp",nullable = false)
    private LocalDateTime timestamp;

    @Column(name="content",nullable = false)
    private String content;
    @ManyToOne
    @JoinColumn(name="username")
    private User username;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Like> likes;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reply> replies;

    public Post(){}

    public Post(Long id, LocalDateTime timestamp, String content ,User username) {
        this.id=id;
        this.timestamp = timestamp;
        this.content = content;
        this.username = username;
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }

    public User  getUsername() {return username;}

    public void setUsername(User  username) {
        this.username = username;
    }
}
