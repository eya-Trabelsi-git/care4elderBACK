package com.example.user.controllers;

import com.example.user.entities.User;
import com.example.user.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/test")
    public String test() {
        User u = new User();
        u.setName("Alice");
        u.setEmail("alice@example.com");
        userService.saveUser(u); // ça va créer la collection si elle n'existe pas
        return "User ajouté !";
    }

    @GetMapping
    public List<User> getAll() {
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }


    @PostMapping
    public User create(@RequestBody User user) {
        return userService.saveUser(user);
    }


    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }
}