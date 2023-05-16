package com.example.demo2.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String username;

    private String firstName;

    private String lastName;

    private String email;

    private String password;



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String username, String firstName, String lastName, String email, String password){
        this.username=username;
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.password=password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username=" + username +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    private List<User> following;
    private List<User> followers;
    private List<Post> posts;

    public List<User> getFollowing() {
        if (following == null) {
            following = new ArrayList<>(); // Initialize the list if it is null
        }
        return following;
    }

    public void setFollowing(List<User> following) {
        this.following = following;
    }

    public List<User> getFollowers() {
        if (followers == null) {
            followers = new ArrayList<>(); // Initialize the list if it is null
        }
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

}
