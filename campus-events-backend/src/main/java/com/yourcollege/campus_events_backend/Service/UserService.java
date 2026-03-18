package com.yourcollege.campus_events_backend.Service;

import com.yourcollege.campus_events_backend.entity.user;
import com.yourcollege.campus_events_backend.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    // Constructor Injection (without Lombok)
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Register user
    public user registerUser(user user) {

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        return userRepository.save(user);
    }

    // Get all users
    public List<user> getAllUsers() {
        return userRepository.findAll();
    }

    // Get user by ID
    public user getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // Delete user
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}