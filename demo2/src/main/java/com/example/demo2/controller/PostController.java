package com.example.demo2.controller;

import com.example.demo2.model.Post;
import com.example.demo2.model.User;
import com.example.demo2.repository.PostRepository;
import com.example.demo2.repository.UserRepository;
import com.example.demo2.service.PostService;
import com.example.demo2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PostController {
    private final PostService postService;



    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping(value="/posts")
    public void createPost(@RequestBody Post post) {
        postService.createPost(post);
    }//

    @Autowired
    private UserRepository userRepository;
    @GetMapping("/users/{username}/posts")
    public List<Post> getPostsByUser(@PathVariable String username) {
        User user = userRepository.getUserByUsername(username);
        return postService.getPostsByUser(user);
    }
    //working

    @GetMapping("/users/{username}/feed")
    public List<Post> getFeed(@PathVariable String username) {
        User user = userRepository.getUserByUsername(username);
        return postService.getPostsByFollowedUsers(user);
    }
    @Autowired
    private UserService userService;
    @Autowired
    private PostRepository postRepository;
    @GetMapping("/posts/followed/{username}")
    public List<Post> getPostsByFollowedUser(@PathVariable("username") String username) {
        List<Post> postsByFollowedUser = new ArrayList<>();

        List<User> followedUsers = userService.getFollowedUsers(username);

        for (User followedUser : followedUsers) {
            List<Post> postsByUser = postRepository.getPostsByUser(followedUser);
            postsByFollowedUser.addAll(postsByUser);
        }

        return postsByFollowedUser;

    }
}
