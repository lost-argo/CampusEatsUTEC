package org.parcial.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class UserRequestDto {
    @NotEmpty
    String username;
    @NotBlank
    @Email
    String email;
    @NotEmpty
    @Size(min=8)
    String password;
    @NotEmpty
    String Role = "User";

    UserRequestDto() {
    }
    public UserRequestDto(String username, String email, String password, String Role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.Role = Role;
    }
}
}
