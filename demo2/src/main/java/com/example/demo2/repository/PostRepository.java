package com.example.demo2.repository;

import com.example.demo2.model.Post;
import com.example.demo2.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepository {

    private List<Post> posts;

    public PostRepository() {
        this.posts = new ArrayList<>();
    }

    public void save(Post post) {
        posts.add(post);
    }

    public void createPost(Post post) {
        save(post);
    }

    public List<Post> getPostsByUser(User user) {
        List<Post> userPosts = new ArrayList<>();

        for (Post post : posts) {
            if (post.getUsername().equals(user.getUsername())) {
                userPosts.add(post);
            }
        }

        return userPosts;
    }

    public List<Post> getPostsByFollowedUsers(User user) {
        List<Post> followedPosts = new ArrayList<>();
        List<User> followedUsers = user.getFollowing();

        for (User followedUser : followedUsers) {
            List<Post> postsByUser = getPostsByUser(followedUser);
            followedPosts.addAll(postsByUser);
        }

        return followedPosts;
    }

    public List<Post> getFeed(User user) {
        List<Post> followedPosts = new ArrayList<>();
        List<User> followedUsers = user.getFollowing();

        for (User followedUser : followedUsers) {
            List<Post> postsByUser = getPostsByUser(followedUser);
            followedPosts.addAll(postsByUser);
        }

        return followedPosts;
    }

    public List<Post> getAllPosts() {
        return posts;
    }

    public Post getPostByContent(String postContent) {
        for (Post post : posts) {
            // Implement your own logic to identify the post (e.g., using the content or other fields)
            if (post.getContent().equals(postContent)) {
                return post;
            }
        }
        return null;
    }
}
