package com.myApp.dao;
import com.myApp.models.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
@NoArgsConstructor
@AllArgsConstructor

public class UserDao implements IUserDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void save(User user) {
        String sql = "INSERT INTO users (first_name, last_name, email, date_of_birth, city) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(
                sql,
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                Date.valueOf(user.getDateOfBirth()),
                user.getCity()
        );
    }
}
