package com.example.demo2.service;

import com.example.demo2.model.Post;
import com.example.demo2.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PostService {
    void createPost(Post post);
    List<Post> getPostsByUser(User user);
    List<Post> getPostsByFollowedUsers(User user);
    Post getPostById(String postId);
    void likePost(String postId, String username);
}