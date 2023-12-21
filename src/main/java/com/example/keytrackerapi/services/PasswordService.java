package com.example.keytrackerapi.services;

import com.example.keytrackerapi.models.Password;
import com.example.keytrackerapi.models.PasswordDTO;
import com.example.keytrackerapi.models.PasswordPostDTO;
import com.example.keytrackerapi.repositories.IPasswordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PasswordService{

    private final IPasswordRepository repository;

    @Autowired
    public PasswordService(IPasswordRepository repository) {
        this.repository = repository;
    }

    public List<PasswordDTO> findByUserId(Long userId) {
        List<Password> passwords = this.repository.findByUserId(userId);
        List<PasswordDTO> passwordsDTOs = new ArrayList<>();
        passwords.forEach(password -> passwordsDTOs.add(Password.toDto(password)));
        return passwordsDTOs;
    }

    public List<Password> findAll() {
        return this.repository.findAll();
    }

    public PasswordDTO findById(Long id) {
        Password password = this.repository.findById(id).orElse(null);
        assert password != null;
        return Password.toDto(password);
    }

    public PasswordDTO save(PasswordPostDTO passwordPostDTO) {
        Password newPassword = Password.fromPostDto(passwordPostDTO);
        this.repository.save(newPassword);
        return Password.toDto(newPassword);
    }

    public PasswordDTO save(Password password) {
        this.repository.save(password);
        return Password.toDto(password);
    }

    public boolean deleteById(Long id) {
        try {
            this.repository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String findPassphraseById(Long id) {
        var passphrase = this.repository.findPassphraseById(id);
        System.out.println(passphrase);
        return passphrase;
    }
}
