package com.miranda.usersapp.services;

import com.miranda.usersapp.models.User;
import com.miranda.usersapp.models.UserRequest;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    Optional<User> findById(Long id);

    User save(User user);

    Optional<User> update(UserRequest user, Long id);

    void delete(Long id);
}
