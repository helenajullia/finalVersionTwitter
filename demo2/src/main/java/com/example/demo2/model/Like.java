package com.example.demo2.model;

import jakarta.persistence.*;

@Entity
@Table(name="likes")
public class Like {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "username", nullable = false)
    private User user;


    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    /*public Like(String username, Long postId) {
        this.username = username;
       this.postId = postId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }*/

    public Like(){

    }
}
