package com.example.demo2.service;

import com.example.demo2.model.Post;
import com.example.demo2.model.User;

import java.util.List;

public interface PostService {
    void createPost(Post post);
    List<Post> getPostsByUser(User user);
    List<Post> getPostsByFollowedUsers(User user);

    List<Post> getFeed(User user);
}