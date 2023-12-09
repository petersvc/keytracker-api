package com.example.keytrackerapi.controllers;

import com.example.keytrackerapi.models.Password;
import com.example.keytrackerapi.services.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/passwords")
public class PasswordController {

    private final PasswordService passwordService;

    @Autowired
    public PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    // @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<Password> findAll() {
        return this.passwordService.findAll();
    }

    // @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/user")
    public List<Password> findByUserId(@RequestParam Long userId, @RequestParam String masterPassword) {
        return this.passwordService.findByUserId(userId);
    }

    // @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}")
    public Password findById(@PathVariable Long id) {
        return this.passwordService.findById(id);
    }

    // @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public Password save(@RequestBody Password password) {
        return this.passwordService.save(password);
    }

    // @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/{id}")
    public Password update(@RequestBody Password password) {
        return this.passwordService.save(password);
    }

    // @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable Long id) {
        return this.passwordService.deleteById(id);
    }
}
