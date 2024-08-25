package com.plus_api.central_plus.Repository;

import com.plus_api.central_plus.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByEmail(String email);
    Optional<UserModel> findByContact(String contact);
    Optional<UserModel> findByResetPasswordToken(String token);
}
