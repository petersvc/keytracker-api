package com.example.keytrackerapi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "tb_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String name;
    public String username;
    public String email;
    public String masterPassword;

    public static User fromPostDto(UserPostDTO userPostDTO) {
        User user = new User();
        user.setName(userPostDTO.name());
        user.setUsername(userPostDTO.username());
        user.setEmail(userPostDTO.email());
        user.setMasterPassword(userPostDTO.masterPassword());
        return user;
    }

    public static UserDTO toDto(User user) {
        return new UserDTO(user.getId(), user.getName(), user.getUsername(), user.getEmail());
    }
}
