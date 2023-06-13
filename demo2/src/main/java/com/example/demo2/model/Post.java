package com.example.demo2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
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

}
