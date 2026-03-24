// package com.example.loginapp.controller;

// import com.example.loginapp.dto.LoginRequest;
// import com.example.loginapp.entity.User;
// import com.example.loginapp.service.UserService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @CrossOrigin
// @RequestMapping("/api/auth")
// public class AuthController {

//     @Autowired
//     private UserService userService;

//     // Signup API
//     @PostMapping("/signup")
//     public ResponseEntity<?> signup(@RequestBody User user) {
//         try {
//             User savedUser = userService.register(user);
//             return ResponseEntity.ok("User registered successfully ✅");
//         } catch (RuntimeException e) {
//             return ResponseEntity.badRequest().body(e.getMessage());
//         }
//     }

//     // Login API
//     @PostMapping("/login")
//     public ResponseEntity<?> login(@RequestBody LoginRequest request) {
//         try {
//             User user = userService.login(request.getEmail(), request.getPassword());
//             return ResponseEntity.ok("Login Successful ✅");
//         } catch (RuntimeException e) {
//             return ResponseEntity.badRequest().body(e.getMessage());
//         }
//     }
// }




package com.example.loginapp.controller;

import com.example.loginapp.entity.User;
import com.example.loginapp.service.UserService;
import com.example.loginapp.utils.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    // ✅ Signup API
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody User user) {
        try {
            userService.register(user);
            return ResponseEntity.ok("User registered successfully ✅");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // ✅ Login API (NOW RETURNS JWT)
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        try {
            User loggedInUser = userService.login(user.getEmail(), user.getPassword());

            // 🔐 Generate JWT Token
            String token = jwtUtil.generateToken(loggedInUser.getEmail());

            // Response
            Map<String, Object> response = new HashMap<>();
            response.put("token", token);
            response.put("email", loggedInUser.getEmail());

            return ResponseEntity.ok(response);

        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}