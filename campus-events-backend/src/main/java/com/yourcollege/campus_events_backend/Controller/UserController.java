package com.yourcollege.campus_events_backend.Controller;
import com.yourcollege.campus_events_backend.entity.user;
import com.yourcollege.campus_events_backend.Service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/users")
@CrossOrigin

public class UserController {
	private final UserService userService;

    // Constructor Injection
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Register user
    @PostMapping("/register")
    public user registerUser(@RequestBody user user) {
        return userService.registerUser(user);
    }

    // Get all users
    @GetMapping
    public List<user> getAllUsers() {
        return userService.getAllUsers();
    }

    // Get user by ID
    @GetMapping("/{id}")
    public user getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // Delete user
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "User deleted successfully";
    }

}
