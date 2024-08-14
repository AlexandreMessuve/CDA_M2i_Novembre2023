package com.example.userapplication.service;

import com.example.userapplication.entity.User;
import com.example.userapplication.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        userRepository.save(user);
        return user;
    }
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }
    public User findById(int id) {
        return userRepository.findById(id).orElse(null);
    }
}
