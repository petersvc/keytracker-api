package com.example.keytrackerapi.repositories;

import com.example.keytrackerapi.models.Password;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPasswordRepository extends JpaRepository<Password, Long> {
    List<Password> findByUserId(Long userId);

    @Query("SELECT p.passphrase FROM Password p WHERE p.id = ?1")
    String findPassphraseById(Long id);
}