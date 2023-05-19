package com.example.demo2.service;

import com.example.demo2.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface UserService {

    List<User> getAllUsers();

    User getUserByUsername(String username);

    void registerUser(User user);

    void updateUser(String username, User user);

    void patchUser(String username, Map<String, String> partialUser);

    void deleteUser(String username);

    List<User> searchUsers(String searchTerm);
    void followUser(String followerUsername, String followingUsername);
    void unfollowUser(String followerUsername, String followingUsername);
    List<String> getFollowedUsers(String followerUsername);

    List<String> getFollowingUsers(String followingUsername);
}
