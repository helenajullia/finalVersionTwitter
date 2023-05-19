package com.example.demo2.service;

import com.example.demo2.model.Like;
import com.example.demo2.model.Post;
import com.example.demo2.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PostService {
    void createPost(Post post);
    List<Post> getPostsByUser(String username);
    List<Post> getPostsByFollowedUsers(User user);
    Post getPostById(String postId);
    void likePost(String postId, Like like);
}