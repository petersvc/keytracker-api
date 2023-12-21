package com.example.keytrackerapi.models;

import java.util.List;

public record PasswordPostDTO(Long userId, String application, boolean favorite, String username, String passphrase, String website, List<String> tags, String notes, boolean inBin, String createdAt) {
}
