package com.example.keytrackerapi.repositories;

import com.example.keytrackerapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
    public User findByUsernameAndMasterPassword(String username, String masterPassword);
}
