package com.example.keytrackerapi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@Entity
@Table(name = "tb_passwords")
public class Password {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public Long userId;
    public String application;
    public boolean favorite;
    public String username;
    public String passphrase;
    public String website;
    @ElementCollection
    private List<String> tags = new ArrayList<>();
    @Column(columnDefinition = "TEXT")
    private String notes;
    public boolean inBin;
    public String createdAt;
}