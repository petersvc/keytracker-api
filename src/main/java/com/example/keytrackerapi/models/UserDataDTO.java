package com.example.keytrackerapi.models;

import java.util.List;

public record UserDataDTO(UserDTO user, List<PasswordDTO> passwords) {
}
