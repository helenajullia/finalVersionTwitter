package com.example.demo2.controller;

import com.example.demo2.in_memory_repo.UserRepositoryInMemo;
import com.example.demo2.model.Like;
import com.example.demo2.model.Post;
import com.example.demo2.model.User;
import com.example.demo2.in_memory_repo.PostRepositoryInMemo;
import com.example.demo2.in_memory_repo.UserRepositoryInMemo;
import com.example.demo2.model.UserFollowerFollowing;
import com.example.demo2.repository.PostRepository;
import com.example.demo2.repository.UserRepository;
import com.example.demo2.service.PostService;
import com.example.demo2.service.UserFollowerFollowingService;
import com.example.demo2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PostController {
    @Autowired
    public PostController(){};
    @Autowired
    private PostService postService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserFollowerFollowingService userFollowerFollowingService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping(value="/posts")
    public void createPost(@RequestBody Post post) {
        postService.createPost(post);
    }

    @GetMapping("/posts/{username}")
        public List<Post> getPostsByUser(@PathVariable String username) {
        User user = userRepository.getUserByUsername(username);
        return postService.getPostsByUser(user);
}

    @GetMapping("/posts/followed/{username}")
    public List<Post> getPostsByFollowedUser(@PathVariable("username") String username) {
        List<Post> postsByFollowedUser = new ArrayList<>();

        List<User> followedUsers = userFollowerFollowingService.getFollowedUsers(username);

        for (User followedUser : followedUsers) {
            List<Post> postsByUser = postRepository.findPostByUsername(followedUser);
            postsByFollowedUser.addAll(postsByUser);
        }
        return postsByFollowedUser;
    }

    @GetMapping("users/{username}/feed")
    public List<Post> getFeed(@PathVariable("username") String username) {
        List<Post> postsByFollowedUser = new ArrayList<>();

        List<User> followedUsers = userFollowerFollowingService.getFollowedUsers(username);

        for (User followedUser : followedUsers) {
            List<Post> postsByUser = postRepository.findPostByUsername(followedUser);
            postsByFollowedUser.addAll(postsByUser);
        }
        return postsByFollowedUser;
    }

    @PutMapping("/posts/{postId}/{username}/like")
    public void likePost(@PathVariable Long postId, @PathVariable String username) {
        Like like = new Like();
        postService.likePost(postId, like, username);
    }

}
