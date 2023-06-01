package com.example.demo2.service;

import com.example.demo2.model.Like;
import com.example.demo2.model.Post;
import com.example.demo2.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PostService {
    void savePost(Post post);

    void createPost(Post post);

    List<String> getLikesByPostId(Long postId);

    List<Post> getPostsByUser(User username);

    List<Post> getPostsByFollowedUser(String username);

    Post getPostById(Long postId);

    void likePost(Long postId, Like like);
}