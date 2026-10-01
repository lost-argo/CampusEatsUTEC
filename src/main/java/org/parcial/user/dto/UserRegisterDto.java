package org.parcial.user.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class UserRegisterDto {
    @NotEmpty
    String username;
    @NotBlank
    @Email
    String email;
    @NotEmpty
    @Size(min=8)
    String password;
    @NotEmpty
    String Role;
}
