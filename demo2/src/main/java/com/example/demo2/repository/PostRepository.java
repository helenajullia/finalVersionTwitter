package com.example.demo2.repository;

import com.example.demo2.model.Post;
import com.example.demo2.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, String> {

    // Create a new post
    Post save(Post post);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO posts (id, timestamp, content, username) " +
            "VALUES (?1, ?2, ?3, ?4)", nativeQuery = true)
    void createPost(
            Long id,
            LocalDateTime timestamp,
            String content,
            User username
    );

    // Retrieve posts by username
    List<Post> findPostByUsername(User username);

    // Retrieve posts by usernames (followed users)
    List<Post> findByUsernameIn(List<User> usernames); //getPostsByFollowedUsers && getFeed

    // Retrieve all posts
    @Override
    List<Post> findAll();
    Post getPostById(Long id);

    Optional<Post> findById(Long id);



    // Retrieve likes by post ID
    @Query("SELECT l.user.username FROM Post p JOIN p.likes l WHERE p.id = :postId")
    List<String> getLikesByPostId(@Param("postId") Long postId);


    // Update a post
    @Modifying
    @Query("UPDATE Post p SET p.content = :content, p.timestamp = :timestamp WHERE p.id = :postId")
    void updatePost(@Param("postId") Long postId, @Param("content") String content, @Param("timestamp") LocalDateTime timestamp);



    // Optional method to delete a post by ID
    void deleteById(Long id);

}
