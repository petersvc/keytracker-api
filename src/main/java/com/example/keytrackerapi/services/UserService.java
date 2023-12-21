package com.example.keytrackerapi.services;

import com.example.keytrackerapi.models.*;
import com.example.keytrackerapi.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    public PasswordService passwordService;
    private final IUserRepository repository;

    @Autowired
    public UserService(IUserRepository repository, PasswordService passwordService) {
        this.repository = repository;
        this.passwordService = passwordService;
    }

    public List<User> findAll() {
        return this.repository.findAll();
    }

    public UserDTO findById(Long id) {
        User user = this.repository.findById(id).orElse(null);
        assert user != null;
        return User.toDto(user);
    }

    public UserDTO save(UserPostDTO user) {
        User newUser = User.fromPostDto(user);
        this.repository.save(newUser);
        return User.toDto(newUser);
    }

    public UserDTO save(User user) {
        this.repository.save(user);
        return User.toDto(user);
    }

    public boolean deleteById(Long id) {
        try {
            this.repository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public UserDataDTO login(String username, String masterPassword) {
        UserDTO userDTO = this.repository.findByUsernameAndMasterPassword(username, masterPassword);
        List<PasswordDTO> passwords = this.passwordService.findByUserId(userDTO.id());
        return new UserDataDTO(userDTO, passwords);
    }

}