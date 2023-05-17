package com.example.demo2.repository;

import com.example.demo2.model.Post;
import com.example.demo2.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
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
                post.setLikes(getLikesByPostId(post.getId()));
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

    public Post getPostById(String postId) {
        for (Post post : posts) {
            if (post.getId().equals(postId)) {
                return post;
            }
        }
        return null;
    }

    public List<String> getLikesByPostId(String postId) {
        Post post = getPostById(postId);
        if (post != null) {
            return post.getLikes();
        } else {
            return Collections.emptyList();
        }
    }

    public void updatePost(Post post) {
        for (int i = 0; i < posts.size(); i++) {
            if (posts.get(i).getId().equals(post.getId())) {
                posts.set(i, post);
                break;
            }
        }
    }
}
