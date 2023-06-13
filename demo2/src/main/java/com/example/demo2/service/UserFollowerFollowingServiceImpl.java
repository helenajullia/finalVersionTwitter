package com.example.demo2.service;

import com.example.demo2.model.User;
import com.example.demo2.model.UserFollowerFollowing;
import com.example.demo2.repository.UserFollowerFollowingRepository;
import com.example.demo2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserFollowerFollowingServiceImpl implements UserFollowerFollowingService {
    private final UserFollowerFollowingRepository userFollowerFollowingRepository;
    @Autowired
    private  UserRepository userRepository;

    public UserFollowerFollowingServiceImpl(UserFollowerFollowingRepository userFollowerFollowingRepository) {
        this.userFollowerFollowingRepository = userFollowerFollowingRepository;
    }

    @Override
    public void followUser(String followerUsername, String  followingUsername) {
        UserFollowerFollowing userFollowerFollowing = new UserFollowerFollowing();
        userFollowerFollowing.setFollowerUsername(userRepository.getReferenceById(followerUsername));
        userFollowerFollowing.setFollowingUsername(userRepository.getReferenceById(followingUsername));
        userFollowerFollowingRepository.save(userFollowerFollowing);
    }

    @Override
    public void unfollowUser(String followerUsername, String followingUsername) {
        User follower = userRepository.findByUsername(followerUsername);
        User following = userRepository.findByUsername(followingUsername);

        if (follower != null && following != null) {
            UserFollowerFollowing userFollowerFollowing = userFollowerFollowingRepository.findByFollowerAndFollowing(follower, following);

            if (userFollowerFollowing != null) {
                userFollowerFollowingRepository.delete(userFollowerFollowing);
            }
        }
    }

    @Override
    public List<User> getFollowedUsers(String followerUsername) {
        User follower = userRepository.findByUsername(followerUsername);

        if (follower != null) {
            return follower.getFollowing();
        }
        return new ArrayList<>();
    }

    @Override
    public List<String> getFollowingUsers(String followingUsername) {
        User following = userRepository.findByUsername(followingUsername);

        if (following != null) {
            List<User> followers = following.getFollowers();
            List<String> followerUsernames = new ArrayList<>();

            for (User follower : followers) {
                followerUsernames.add(follower.getUsername());
            }
            return followerUsernames;
        }
        return new ArrayList<>();
    }
}
