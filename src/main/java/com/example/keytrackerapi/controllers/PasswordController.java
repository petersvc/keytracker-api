package com.example.keytrackerapi.controllers;

import com.example.keytrackerapi.models.Password;
import com.example.keytrackerapi.models.PasswordDTO;
import com.example.keytrackerapi.models.PasswordPostDTO;
import com.example.keytrackerapi.services.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/passwords")
public class PasswordController {

    private final PasswordService passwordService;

    @Autowired
    public PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @GetMapping
    public List<Password> findAll() {
        return this.passwordService.findAll();
    }

    @GetMapping("/user")
    public List<PasswordDTO> findByUserId(@RequestParam Long userId) {
        return this.passwordService.findByUserId(userId);
    }

    @GetMapping("/{id}")
    public PasswordDTO findById(@PathVariable Long id) {
        return this.passwordService.findById(id);
    }

    @PostMapping
    public PasswordDTO save(@RequestBody PasswordPostDTO password) {
        return this.passwordService.save(password);
    }

    @PutMapping("/{id}")
    public PasswordDTO update(@RequestBody Password password) {
        return this.passwordService.save(password);
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable Long id) {
        return this.passwordService.deleteById(id);
    }

    @GetMapping("/{id}/passphrase")
    public Map<String, String> findPassphraseById(@PathVariable Long id) {
        Map<String, String> response = new HashMap<>();
        response.put("passphrase", this.passwordService.findPassphraseById(id));
        return response;
    }
}
