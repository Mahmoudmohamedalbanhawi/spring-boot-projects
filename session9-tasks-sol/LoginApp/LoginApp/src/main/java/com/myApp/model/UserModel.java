package com.myApp.model;

import lombok.Getter;

import lombok.Setter;

import org.springframework.stereotype.Component;
import specialAnnotation.PasswordMatches;

import javax.validation.constraints.*;


@Component
@Setter
@Getter
@specialAnnotation.PasswordMatches
public class UserModel
{

    @NotBlank(message = "this field cannot be empty or null")
    private String userName;


    @NotBlank(message = "the field cannot be empty or null")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z.-]+\\.[a-zA-Z]{2,}$" , message = "Please enter a valid email address")
    private String email;


    @NotNull(message = "Password is required")

    @Pattern(regexp = "^[a-zA-Z0-9]{6,20}" , message = "please enter a valid paswword at least 6 characters and max 20 characters")
    private String password;
    @NotNull(message = "confirm password is required")

    private String confirmPassword;
}
