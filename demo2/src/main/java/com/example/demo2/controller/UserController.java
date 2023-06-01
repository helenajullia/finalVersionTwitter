package com.example.demo2.controller;

import com.example.demo2.model.User;
import com.example.demo2.service.UserFollowerFollowingService;
import com.example.demo2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@RestController
public class UserController {
    @Autowired
    public UserController(){};
    @Autowired
    private UserService userService;
    @Autowired
    private UserFollowerFollowingService userFollowerFollowingService;


    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public void register(@RequestBody User user) {
        userService.registerUser(user);
    }

    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/users/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> searchUsers(@RequestParam String searchTerm) {
        return userService.searchUsers(searchTerm);
    }//   localhost:8081/users/search?searchTerm=Helena

    @PostMapping("/users/{followerUsername}/follow/{followingUsername}")
    public void followUser(@PathVariable String followerUsername, @PathVariable String  followingUsername) {
        userFollowerFollowingService.followUser(followerUsername, followingUsername);
    }//localhost:8081/users/helenajullia/follow/mariussebastian

    @PostMapping("/users/{followerUsername}/unfollow/{followingUsername}")
    public void unfollowUser(@PathVariable String followerUsername, @PathVariable String followingUsername) {
        userFollowerFollowingService.unfollowUser(followerUsername, followingUsername);
    }

    @DeleteMapping(value = "/users/unregister/{username}")
    public void deleteUser(@PathVariable String username) {
        userService.deleteUser(username);
    }

//    @GetMapping("/users/{followerUsername}/followed-users")
//    public List<User> getFollowedUsers(@PathVariable String followerUsername) {
//        return userFollowerFollowingService.getFollowedUsers(followerUsername);
//    }
//
//    @GetMapping("/users/{followerUsername}/following-users")
//    public List<String> getFollowingUsers(@PathVariable String followerUsername) {
//        return userFollowerFollowingService.getFollowingUsers(followerUsername);
//    }

//    @GetMapping(value = "/users/{username}", produces = MediaType.APPLICATION_XML_VALUE)
//    public User getUserByUsername(@PathVariable User username) {
//        return userService.getUserByUsername(username);
//    }
//
//    @GetMapping(value = "/users/byParam", produces = MediaType.APPLICATION_JSON_VALUE)
//    public User getUserByParam(@RequestParam User username) {
//        return userService.getUserByUsername(username);
//    }

//    @PutMapping(value = "/users/{username}", consumes = MediaType.APPLICATION_JSON_VALUE)
//    public void updateUser(@PathVariable String username, @RequestBody User user) {
//        userService.updateUser(username, user);
//    }
//
//    @PatchMapping(value = "/users/{username}", consumes = MediaType.APPLICATION_JSON_VALUE)
//    public void patchUser(@PathVariable String username, @RequestBody Map<String, String> partialUser) {
//        userService.patchUser(username, partialUser);
//    }

}
