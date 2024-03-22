package com.miranda.cartapp.controllers;

import com.miranda.cartapp.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {
    @GetMapping
    public List<User> user(){
        List<User> users = new ArrayList<>();


        User user = new User();
        user.setId(2L);
        user.setName("Fernando");
        user.setLastName("Miranda");

        User user2 = new User();
        user2.setId(2L);
        user2.setName("Fernando");
        user2.setLastName("Miranda");

        users.add(user);
        users.add(user2);
        return users;
    }
}
