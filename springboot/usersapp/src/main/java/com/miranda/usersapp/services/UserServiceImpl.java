package com.miranda.usersapp.services;

import com.miranda.usersapp.models.User;
import com.miranda.usersapp.models.UserRequest;
import com.miranda.usersapp.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public Optional<User> update(UserRequest user, Long id) {
        Optional<User> optionalUser = findById(id);

        if (optionalUser.isPresent()) {
            User userDB = optionalUser.get();
            userDB.setUsername(user.getUsername());
            userDB.setEmail(user.getEmail());
            return Optional.of(save(userDB));
        }

        return Optional.empty();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userRepository.deleteById(id);

    }
}
