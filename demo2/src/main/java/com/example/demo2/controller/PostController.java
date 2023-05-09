package com.example.demo2.controller;

import com.example.demo2.model.Post;
import com.example.demo2.model.User;
import com.example.demo2.repository.UserRepository;
import com.example.demo2.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/posts")
    public void createPost(@RequestBody Post post) {
        postService.createPost(post);
    }

    @Autowired
    private UserRepository userRepository;
    @GetMapping("/users/{username}/posts")
    public List<Post> getPostsByUser(@PathVariable String username) {
        User user = userRepository.getUserByUsername(username);
        return postService.getPostsByUser(user);
    }

    @GetMapping("/users/{username}/feed")
    public List<Post> getFeed(@PathVariable String username) {
        User user = userRepository.getUserByUsername(username);
        return postService.getPostsByFollowedUsers(user);
    }
}
