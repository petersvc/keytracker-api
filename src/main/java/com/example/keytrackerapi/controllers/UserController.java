package com.example.keytrackerapi.controllers;

import com.example.keytrackerapi.models.User;
import com.example.keytrackerapi.models.UserDTO;
import com.example.keytrackerapi.models.UserDataDTO;
import com.example.keytrackerapi.models.UserPostDTO;
import com.example.keytrackerapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> findAll() {
        return this.userService.findAll();
    }

    @GetMapping("/{id}")
    public UserDTO findById(@PathVariable Long id) {
        return this.userService.findById(id);
    }

    @PostMapping("/login")
    public UserDataDTO login(@RequestParam String username, @RequestParam String masterPassword) {
        return this.userService.login(username, masterPassword);
    }

    @PostMapping
    public UserDTO save(@RequestBody UserPostDTO user) {
        return this.userService.save(user);
    }

    @PutMapping("/{id}")
    public UserDTO update(@RequestBody User user) {
        return this.userService.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        this.userService.deleteById(id);
    }

}
