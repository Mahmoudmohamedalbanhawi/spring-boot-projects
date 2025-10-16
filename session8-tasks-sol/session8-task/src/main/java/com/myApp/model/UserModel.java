package com.myApp.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Component
@Setter
@Getter
public class UserModel
{
    private String userName;
    private String password;
    private String country;
    private String programmingLanguage;
    private String operatingSystem;


}
