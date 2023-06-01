package com.example.demo2.repository;

import com.example.demo2.model.User;
import com.example.demo2.model.UserFollowerFollowing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserFollowerFollowingRepository extends JpaRepository<UserFollowerFollowing, String> {


    @Query("SELECT u FROM UserFollowerFollowing u JOIN u.follower follower WHERE follower.username = :followerUsername")
    List<UserFollowerFollowing> findByFollowerUsername(String followerUsername);

    @Query("SELECT u FROM UserFollowerFollowing u JOIN u.following following WHERE following.username = :followingUsername")
    List<UserFollowerFollowing> findByFollowingUsername(@Param("followingUsername") String followingUsername);

    @Modifying
    @Query("UPDATE UserFollowerFollowing u SET u.following = :following WHERE u.follower = :follower")
    void followUser(@Param("follower") User follower, @Param("following") User following);


    @Modifying
    @Query("UPDATE UserFollowerFollowing u SET u.following = :following WHERE u.follower = :follower")
    void unfollowUser(@Param("follower") User follower, @Param("following") User following);

    @Query("SELECT u FROM UserFollowerFollowing u WHERE u.follower = :follower AND u.following = :following")
    UserFollowerFollowing findByFollowerAndFollowing(@Param("follower") User follower, @Param("following") User following);
}
