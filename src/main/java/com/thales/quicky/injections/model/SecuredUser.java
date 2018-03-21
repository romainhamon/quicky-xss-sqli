package com.thales.quicky.injections.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity(name = "user")
public class SecuredUser {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 10, message = "Max 3, Min 10")
    @Pattern(regexp = "^[\\p{Alnum}]+$")
    private String username;

    @NotNull
    @Pattern(regexp=".+@.+\\.[a-z]+", message="Invalid email address!")
    private String email;

}
