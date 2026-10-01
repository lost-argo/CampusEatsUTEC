package org.parcial.auth.domain;

import org.parcial.auth.components.EmailAlreadyExistsException;
import org.parcial.auth.components.JwtService;
import org.parcial.auth.dto.SignUpRequest;
import org.parcial.auth.dto.TokenResponse;
import org.parcial.user.domain.User;
import org.parcial.user.infrastructure.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public TokenResponse signUp(SignUpRequest request){
        if (userRepository.findByEmail(request.getEmail()).isPresent()){
            throw new EmailAlreadyExistsException("Email already sgined");
        }
        User user = userRepository.save(
                new User(request.getEmail(),passwordEncoder.encode(request.getPassword()),request.getFirstName(),request.getLastName(), request.getRole()));
        return new TokenResponse(jwtService.generateToken(user));
    }

    public TokenResponse signIn(String username, String password){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        User user = userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new TokenResponse(jwtService.generateToken(user));
    }
}
