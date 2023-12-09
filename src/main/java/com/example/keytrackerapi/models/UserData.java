package com.example.keytrackerapi.models;

import java.util.List;

public record UserData(User user, List<Password> passwords) {
}
