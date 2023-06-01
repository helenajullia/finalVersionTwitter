package com.example.demo2.service;

import com.example.demo2.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface UserService {

    List<User> getAllUsers();

    User getUserByUsername(String username);

    void registerUser(User user);

    void updateUser(String username, User user);

    void deleteUser(String username);

    List<User> searchUsers(String searchTerm);
}
