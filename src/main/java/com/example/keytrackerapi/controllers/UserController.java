package com.example.keytrackerapi.controllers;

import com.example.keytrackerapi.models.User;
import com.example.keytrackerapi.models.UserData;
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

    //@CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<User> findAll() {
        return this.userService.findAll();
    }

    //@CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        return this.userService.findById(id);
    }

    //@CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/login")
    public UserData login(@RequestParam String username, @RequestParam String masterPassword) {
        return this.userService.login(username, masterPassword);
    }

    //@CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public User save(@RequestBody User user) {
        return this.userService.save(user);
    }

    //@CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/{id}")
    public User update(@RequestBody User user) {
        return this.userService.save(user);
    }

    //@CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        this.userService.deleteById(id);
    }
}
