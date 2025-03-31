package com.abletocode.bookstore.auth;

import com.abletocode.bookstore.role.RoleRepository;
import com.abletocode.bookstore.user.User;
import com.abletocode.bookstore.user.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;


    public void register(RegistrationRequest request) {
    var userRole = roleRepository.findByName("USER")
            .orElseThrow(() -> new IllegalStateException("User not found"));
    var user = User.builder()
            .firstname(request.getFirstname())
            .lastname(request.getLastname())
            .email(request.getEmail())
            .password(passwordEncoder.encode(request.getPassword()))
            .accountLoceked(false)
            .enabled(true)
            .roles(List.of(userRole))
            .build();
userRepository.save(user);
//sendValidationEmail(user);
    }
}
