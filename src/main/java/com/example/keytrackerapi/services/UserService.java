package com.example.keytrackerapi.services;

import com.example.keytrackerapi.models.BaseService;
import com.example.keytrackerapi.models.Password;
import com.example.keytrackerapi.models.User;
import com.example.keytrackerapi.models.UserData;
import com.example.keytrackerapi.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends BaseService<User, IUserRepository> {

    public PasswordService passwordService;

    @Autowired
    public UserService(IUserRepository repository, PasswordService passwordService) {
        super(repository);
        this.passwordService = passwordService;
    }

    public UserData login(String username, String masterPassword) {
        User user = this.repository.findByUsernameAndMasterPassword(username, masterPassword);
        List<Password> passwords = this.passwordService.findByUserId(user.getId());
        return new UserData(user, passwords);
    }

}