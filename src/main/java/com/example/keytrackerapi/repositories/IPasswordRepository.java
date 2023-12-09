package com.example.keytrackerapi.repositories;

import com.example.keytrackerapi.models.Password;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPasswordRepository extends JpaRepository<Password, Long> {
    public List<Password> findByUserId(Long userId);
}