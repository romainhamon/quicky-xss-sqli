package com.thales.quicky.injections.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class User {

    private Long id;

    @NotNull
    @Size(min = 3, max = 10, message = "Max 3, Min 10")
    @Pattern(regexp = "^[\\p{Alnum}]+$")
    private String username;

    @NotNull
    @Pattern(regexp=".+@.+\\.[a-z]+", message="Invalid email address!")
    private String email;

}
