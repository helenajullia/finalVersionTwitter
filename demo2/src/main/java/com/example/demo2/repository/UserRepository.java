package com.example.demo2.repository;
import com.example.demo2.model.User;
import com.example.demo2.advice.exception.UserNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {
    private Map<String, User> users;

    public UserRepository() {
        users = new HashMap<>();
    }

    public boolean isUsernameTaken(String username) {
        return users.containsKey(username);
    }

    public void addUser(User user) {
        users.put(user.getUsername(), user);
    }

    public void deleteUser(String username) {
        users.remove(username);
    }

    public User getUserByUsername(String username) {
        for (User user : users.values()) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        throw new UserNotFoundException(String.format("User with username %s was not found", username));
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    public void createUser(User user) {
        users.put(user.getUsername(), user);
    }

    public void updateUser(String username, User user) {
        getUserByUsername(username);
        user.setUsername(username);
        users.put(username, user);
    }
    public void followUser(String followerUsername, String followedUsername) {
        User follower = getUserByUsername(followerUsername);
        User followed = getUserByUsername(followedUsername);

        if (follower != null && followed != null) {
            follower.getFollowing().add(followed); // Add the followed user to the follower's following list
        }
    }

    public void unfollowUser(String followerUsername, String followingUsername) {
        User follower = users.get(followerUsername);
        User following = users.get(followingUsername);

        if (follower != null && following != null) {
            follower.getFollowing().remove(following.getUsername());

        }
    }

    public List<String> getFollowers(String username) {
        List<String> followers = new ArrayList<>();

        for (User user : users.values()) {
            if (user.getFollowing().contains(username)) {
                followers.add(user.getUsername());
            }
        }
        return followers;
    }
}
