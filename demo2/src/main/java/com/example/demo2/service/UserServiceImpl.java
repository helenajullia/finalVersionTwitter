package com.example.demo2.service;

import com.example.demo2.model.User;
import com.example.demo2.repository.UserRepository;
import com.example.demo2.util.UserUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;



@Service
public class UserServiceImpl implements UserService {

    public UserServiceImpl(){};
    @Autowired
    private  UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @Override
    public User getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }
    @Override
    public void registerUser(User user) {
        userRepository.save(user);
    }
    @Override
    public void updateUser(String username, User user) {
        userRepository.updateUser(username, user);
    }
    @Transactional
    public void deleteUser(String username) {
        userRepository.deleteUser(username);
    }

    @Override
    public List<User> searchUsers(String searchTerm) {
        return userRepository.searchUsers(searchTerm)   ;
    }

}
