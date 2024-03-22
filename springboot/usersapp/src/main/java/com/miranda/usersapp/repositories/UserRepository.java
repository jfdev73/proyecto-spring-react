package com.miranda.usersapp.repositories;

import com.miranda.usersapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
