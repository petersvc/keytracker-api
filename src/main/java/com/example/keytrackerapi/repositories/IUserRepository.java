package com.example.keytrackerapi.repositories;

import com.example.keytrackerapi.models.User;
import com.example.keytrackerapi.models.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long> {
    public UserDTO findByUsernameAndMasterPassword(String username, String masterPassword);
}
