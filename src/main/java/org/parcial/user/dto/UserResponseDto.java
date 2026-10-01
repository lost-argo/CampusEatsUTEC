package org.parcial.user.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.apache.catalina.User;

public class UserResponseDto {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NotEmpty
    String username;
    @NotBlank
    @Email
    String email;
    @NotEmpty
    String Role = "User";

    UserResponseDto() {
    }
    public UserResponseDto(Long id,  String username, String email, String Role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.Role = Role;
    }
}