package com.example.demo2.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
@Entity
@Table(name="replay")
public class Reply {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name="id_post",nullable = false)
    private Post post;

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }


    @Column(name="ispublic",nullable = false)
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

    public Long getReplyId() {
        return replyId;
    }

    public void setReplyId(Long replyId) {
        this.replyId = replyId;
    }

    /*public void setPostId(Long postId) {
        this.postId = postId;
    }
    public Long getPostId() {
        return postId;
    }*/

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }


    /*public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }*/

    public Reply(Long replyId, String content, LocalDateTime timestamp/*, String username, Long postId*/ , Post post, Boolean isPublic) {
        this.replyId = replyId;
        this.content = content;
        this.timestamp = timestamp;
        //this.username = username;
       // this.postId = postId;
        this.post = post;
        this.isPublic = isPublic;
    }

    public Reply(){

    }
}
