package com.myApp.services;

import com.myApp.dao.UserDao;
import com.myApp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    @Autowired
    private UserDao userDao;
    public void save(User user)
    {
        validateUser(user);
        userDao.save(user);
    }
    private void validateUser(User user)
    {
        if(user.getFirstName() == null || user.getFirstName().trim().isEmpty())
        {
            throw  new IllegalArgumentException("first name can't be empty");
        }
        if(user.getLastName() == null || user.getLastName().trim().isEmpty())
        {
            throw new IllegalArgumentException("last name can not be empty");
        }
        if(user.getCity() == null || user.getCity().trim().isEmpty())
        {
            throw new IllegalArgumentException("city can not be empty");
        }
        if(user.getDateOfBirth() == null)
        {
            throw new IllegalArgumentException("date can't be empty");
        }
        if(user.getEmail() == null || user.getEmail().trim().isEmpty())
        {
            throw new IllegalArgumentException("email can not be empty");
        }
    }
}
