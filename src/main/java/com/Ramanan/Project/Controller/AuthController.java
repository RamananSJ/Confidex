//package com.Ramanan.Project.Controller;
//
//import com.Ramanan.Project.Model.User;
////import com.Ramanan.Project.Security.JwtUtil;
////import com.Ramanan.Project.Security.UserDetailsServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/auth")
//public class AuthController {
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private JwtUtil jwtUtil;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    private final UserDetailsService userDetailsService;
//
//    public AuthController(AuthenticationManager authenticationManager,
//                          UserDetailsService userDetailsService,
//                          JwtUtil jwtUtil) {
//        this.authenticationManager = authenticationManager;
//        this.userDetailsService = userDetailsService;
//        this.jwtUtil = jwtUtil;
//    }
//
//    @PostMapping("/login")
//    public String login(@RequestParam String email, @RequestParam String password) {
//        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
//
//        // Fetch user details from the database
//        UserDetails userDetails = userDetailsService.loadUserByUsername(email);
//
//        // Generate JWT token using UserDetails
//        return jwtUtil.generateToken(userDetails);
//    }
//
//
//    @PostMapping("/register")
//    public String register(@RequestBody User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        return "User registered successfully!";
//    }
//}
