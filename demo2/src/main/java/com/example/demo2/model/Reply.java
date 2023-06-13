package com.example.demo2.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Data
@Entity
@Table(name="replay")
public class Reply {
    @Column(name="ispublic",nullable = false)
    private boolean ispublic;
    @Id
    @Column(name="id",nullable = false,unique = true)
    private Long replyId;
    @Column(name="content",nullable = false)
    private String content;
    @Column(name="timestamp",nullable = false)
    private LocalDateTime timestamp;
    @ManyToOne
    @JoinColumn(name="username",nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name="id_post",nullable = false)
    private Post post;

    public Reply(){

    }
}
