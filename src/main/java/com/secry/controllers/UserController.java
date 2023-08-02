package com.secry.controllers;

import com.secry.models.User;
import com.secry.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping(value = "/")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @GetMapping(value = "/{userId}")
    public Optional<User> getUser(@PathVariable String userId) {
        return userRepository.findById(userId);
    }
    @PostMapping(value = "/create")
    public User addNewUsers(@RequestBody User user) {
        return userRepository.save(user);
    }
}
