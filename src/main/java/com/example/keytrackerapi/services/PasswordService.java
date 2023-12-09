package com.example.keytrackerapi.services;

import com.example.keytrackerapi.models.BaseService;
import com.example.keytrackerapi.models.Password;
import com.example.keytrackerapi.repositories.IPasswordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasswordService extends BaseService<Password, IPasswordRepository> {

    @Autowired
    public PasswordService(IPasswordRepository repository) {
        super(repository);
    }

    public List<Password> findByUserId(Long userId) {
        return this.repository.findByUserId(userId);
    }
}
