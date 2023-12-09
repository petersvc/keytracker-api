package com.example.keytrackerapi.models;
import java.util.List;

public record PasswordDTO(Long id, Long userId, String application, boolean favorite, String username, String website, List<String> tags, String notes, boolean inBin, String createdAt) {
}