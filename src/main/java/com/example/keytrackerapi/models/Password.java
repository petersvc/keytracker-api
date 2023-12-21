package com.example.keytrackerapi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
    @CollectionTable(name = "password_tags", joinColumns = @JoinColumn(name = "password_id"))
    private List<String> tags;
    @Column(columnDefinition = "TEXT")
    private String notes;
    public boolean inBin;
    public String createdAt;

    public static Password fromPostDto(PasswordPostDTO passwordPostDTO) {
        Password password = new Password();
        password.setUserId(passwordPostDTO.userId());
        password.setApplication(passwordPostDTO.application());
        password.setFavorite(passwordPostDTO.favorite());
        password.setUsername(passwordPostDTO.username());
        password.setPassphrase(passwordPostDTO.passphrase());
        password.setWebsite(passwordPostDTO.website());
        password.setTags(passwordPostDTO.tags());
        password.setNotes(passwordPostDTO.notes());
        password.setInBin(passwordPostDTO.inBin());
        password.setCreatedAt(passwordPostDTO.createdAt());
        return password;
    }

    public static PasswordDTO toDto(Password password) {
        return new PasswordDTO(password.getId(), password.getUserId(), password.getApplication(), password.isFavorite(), password.getUsername(), password.getWebsite(), password.getTags(), password.getNotes(), password.isInBin(), password.getCreatedAt());
    }
}