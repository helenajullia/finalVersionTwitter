package com.example.demo2.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JoinColumnOrFormula;

import java.util.List;
import java.util.UUID;
@Data
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