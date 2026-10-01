package org.parcial.user.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class User implements UserDetails {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NotEmpty
    String username;
    @NotBlank
    @Email
    String email;
    @NotEmpty
    String password;
    @NotEmpty
    String Role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return User.getRole().stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName())).collect(Collectors.toList())
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
