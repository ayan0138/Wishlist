package com.example.wishlistproject.service;

import com.example.wishlistproject.model.User;
import com.example.wishlistproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public boolean createUser(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return false;
        }
        userRepository.save(user);
        return true;
    }

    public User loginUser(String email, String password) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
} //hej