package com.miranda.usersapp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class UserRequest {


    @NotBlank
    @Size(min = 4, max = 20)
    @Column(unique = true)
    private String username;


    @NotBlank
    @Email
    @Column(unique = true)
    private String email;

}
