package com.example.demo2.service;

import com.example.demo2.model.User;
import com.example.demo2.repository.UserRepository;
import com.example.demo2.service.UserService;
import com.example.demo2.repository.UserRepository;
import com.example.demo2.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;



@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserUtil userUtil;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserUtil userUtil) {
        this.userRepository = userRepository;
        this.userUtil = userUtil;
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public User getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }

    public void registerUser(User user) {
        userRepository.createUser(user);
    }

    public void updateUser(String username, User user) {
        userRepository.updateUser(username, user);
    }

    public void patchUser(String username, Map<String, String> partialUser) {
        User user = userRepository.getUserByUsername(username);
        userUtil.patchUser(user, partialUser);
        userRepository.updateUser(username, user);
    }

    public void deleteUser(String username) {
        userRepository.deleteUser(username);
    }

    @Override
    public List<User> searchUsers(String searchTerm) {
        List<User> allUsers = getAllUsers();
        List<User> searchResults = new ArrayList<>();

        for (User user : allUsers) {
            if (user.getUsername().equalsIgnoreCase(searchTerm)
                    || user.getFirstName().equalsIgnoreCase(searchTerm)
                    || user.getLastName().equalsIgnoreCase(searchTerm)) {
                searchResults.add(user);
            }
        }

        return searchResults;
    }


    public void followUser(String followerUsername, String followingUsername) {
        User follower = userRepository.getUserByUsername(followerUsername);
        User following = userRepository.getUserByUsername(followingUsername);

        if (follower != null && following != null) {
            follower.getFollowing().add(following); // Add the followed user to the follower's following list
        }
    }

    public void unfollowUser(String followerUsername, String followingUsername) {
        userRepository.unfollowUser(followerUsername, followingUsername);
    }

    public List<String> getFollowers(String username) {
        return userRepository.getFollowers(username);
    }

    public List<User> getFollowedUsers(String username) {
        User user = userRepository.getUserByUsername(username);
        List<User> followingUsers = user.getFollowing();
        List<User> followedUsers = new ArrayList<>();

        for (User followingUser : followingUsers) {
            User followedUser = userRepository.getUserByUsername(followingUser.getUsername());
            if (followedUser != null) {
                followedUsers.add(followedUser);
            }
        }

        return followedUsers;
    }


}
