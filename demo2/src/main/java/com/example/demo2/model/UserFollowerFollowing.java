package com.example.demo2.model;

import jakarta.persistence.*;
import org.hibernate.annotations.JoinColumnOrFormula;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name="userfollowersfollowing")
public class UserFollowerFollowing {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "following_username", referencedColumnName = "username")
    private User following;
    @ManyToOne
    @JoinColumn(name = "follower_username", referencedColumnName = "username")
    private User follower;

    public UserFollowerFollowing(){}

    public UserFollowerFollowing(Long id, User follower, User following) {
        this.id = id;
        this.follower = follower;
        this.following = following;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFollowerUsername() {
        return follower.getUsername();
    }

    public void setFollowerUsername(User follower) {
        this.follower = follower;
    }

    public String getFollowingUsername() {
        return following.getUsername();
    }

    public void setFollowingUsername(User following) {
        this.following = following;
    }
}