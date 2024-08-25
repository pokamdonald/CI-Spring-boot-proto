package com.plus_api.central_plus.Service;

import com.plus_api.central_plus.Model.UserModel;
import com.plus_api.central_plus.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // User registration
    public UserModel registerUser(UserModel userModel) {
        // Encode the password
        userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
        return userRepository.save(userModel);
    }

    // User login
    public Optional<UserModel> loginUser(String email, String password) {
        Optional<UserModel> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            if (passwordEncoder.matches(password, user.get().getPassword())) {
                return user;
            }
        }
        return Optional.empty();
    }

    // Update contact and password
    public UserModel updateUser(Long userId, String contact, String password) {
        Optional<UserModel> user = userRepository.findById(userId);
        if (user.isPresent()) {
            UserModel updatedUser = user.get();
            updatedUser.setContact(contact);
            if (password != null && !password.isEmpty()) {
                updatedUser.setPassword(passwordEncoder.encode(password));
            }
            return userRepository.save(updatedUser);
        }
        throw new RuntimeException("User not found");
    }

    // Generate a password reset token
    public String generateResetPasswordToken(String email) {
        Optional<UserModel> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            String token = UUID.randomUUID().toString();
            user.get().setResetPasswordToken(token);
            userRepository.save(user.get());
            return token;
        }
        throw new RuntimeException("User not found");
    }

    // Reset password using the token
    public UserModel resetPassword(String token, String newPassword) {
        Optional<UserModel> user = userRepository.findByResetPasswordToken(token);
        if (user.isPresent()) {
            user.get().setPassword(passwordEncoder.encode(newPassword));
            user.get().setResetPasswordToken(null); // Clear the token after successful reset
            return userRepository.save(user.get());
        }
        throw new RuntimeException("Invalid token");
    }
}
