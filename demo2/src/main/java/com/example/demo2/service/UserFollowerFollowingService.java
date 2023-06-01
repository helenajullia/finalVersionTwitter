package com.example.demo2.service;

import com.example.demo2.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserFollowerFollowingService {
    void followUser(String followerUsername, String followingUsername);
    void unfollowUser(String followerUsername, String followingUsername);
    List<User> getFollowedUsers(String followerUsername);
    List<String> getFollowingUsers(String followingUsername);
}