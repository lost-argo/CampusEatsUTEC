package org.parcial.user.infrastructure;

import org.parcial.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional findByEmail(String email);
}