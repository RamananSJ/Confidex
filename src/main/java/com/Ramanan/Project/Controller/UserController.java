package com.Ramanan.Project.Controller;


import com.Ramanan.Project.Model.User;
import com.Ramanan.Project.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/team/{teamId}")
    public ResponseEntity<List<User>> getUsersByTeam(@PathVariable Long teamId) {
        return ResponseEntity.ok(userService.getUsersByTeam(teamId));
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        return ResponseEntity.ok(userService.updateUser(id, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/division/{divisionId}")
    public ResponseEntity<List<User>> getUsersByDivision(@PathVariable Long divisionId) {
        return ResponseEntity.ok(userService.getUsersByDivision(divisionId));
    }
}
