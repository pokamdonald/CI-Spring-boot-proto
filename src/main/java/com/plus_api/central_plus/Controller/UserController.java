package com.plus_api.central_plus.Controller;

import com.plus_api.central_plus.Dto.LoginRequest;
import com.plus_api.central_plus.Dto.UpdateUserRequest;
import com.plus_api.central_plus.Dto.UpdateUserRequest;
import com.plus_api.central_plus.Model.UserModel;
import com.plus_api.central_plus.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserModel> registerUser(@RequestBody UserModel userModel) {
        return ResponseEntity.ok(userService.registerUser(userModel));
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginRequest loginRequest) {
        Optional<UserModel> user = userService.loginUser(loginRequest.getEmail(), loginRequest.getPassword());
        if (user.isPresent()) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserModel> updateUser(@PathVariable Long id, @RequestBody UpdateUserRequest updateRequest) {
        UserModel updatedUser = userService.updateUser(id, updateRequest.getContact(), updateRequest.getPassword());
        return ResponseEntity.ok(updatedUser);
    }

    @PostMapping("/reset-password")
    public ResponseEntity<String> generateResetToken(@RequestParam String email) {
        String token = userService.generateResetPasswordToken(email);
        // Here, you would typically send the token to the user's email
        return ResponseEntity.ok("Password reset token generated: " + token);
    }

    @PostMapping("/reset-password/confirm")
    public ResponseEntity<String> resetPassword(@RequestParam String token, @RequestParam String newPassword) {
        userService.resetPassword(token, newPassword);
        return ResponseEntity.ok("Password reset successful");
    }
}
