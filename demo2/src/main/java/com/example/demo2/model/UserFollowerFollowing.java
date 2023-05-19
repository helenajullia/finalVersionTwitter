package com.example.demo2.model;

import java.util.List;

public class UserFollowerFollowing {
    private User user;
    private List<String> followers;
    private List<String> following;

    public UserFollowerFollowing(User user, List<String> followers, List<String> following) {
        this.user = user;
        this.followers = followers;
        this.following = following;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<String> getFollowers() {
        return followers;
    }

    public void setFollowers(List<String> followers) {
        this.followers = followers;
    }

    public List<String> getFollowing() {
        return following;
    }

    public void setFollowing(List<String> following) {
        this.following = following;
    }
}