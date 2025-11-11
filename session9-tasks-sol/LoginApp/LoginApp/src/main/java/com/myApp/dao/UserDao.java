package com.myApp.dao;

import com.myApp.model.UserModel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
@NoArgsConstructor
@AllArgsConstructor

public class UserDao implements IUserDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void save(UserModel user) {
        String sql = "INSERT INTO users (user_name, email, password, confirmPassword) VALUES (?, ?, ? , ?)";
        jdbcTemplate.update(
                sql,
                user.getUserName(),
                user.getEmail(),
                user.getPassword(),
                user.getConfirmPassword()

        );
    }
}
