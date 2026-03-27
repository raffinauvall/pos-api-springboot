package com.learnspring.pos_api.controller;

import com.learnspring.pos_api.dto.ApiResponse;
import com.learnspring.pos_api.model.User;
import com.learnspring.pos_api.repository.UserRepository;
import com.learnspring.pos_api.security.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    @PostMapping("/register")
    public ApiResponse<User> register(@RequestBody User user) {
        return new ApiResponse<>("success", "User created", userRepository.save(user));
    }

    @PostMapping("/login")
    public ApiResponse<String> login(@RequestBody User user) {
        User dbUser = userRepository.findByUsername(user.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!dbUser.getPassword().equals(user.getPassword())) {
            throw new RuntimeException("Wrong password");
        }

        String token = jwtUtil.generateToken(user.getUsername());

        return new ApiResponse<>("success", "Login success", token);
    }
}


