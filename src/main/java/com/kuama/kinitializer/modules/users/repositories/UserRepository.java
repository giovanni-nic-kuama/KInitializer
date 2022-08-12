package com.kuama.kinitializer.modules.users.repositories;

import com.kuama.kinitializer.modules.users.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findByEmail(String email);


}
