package com.myApp.services;

import com.myApp.dao.UserDao;
import com.myApp.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    @Autowired
    private UserDao userDao;
    public void save(UserModel user)
    {

        userDao.save(user);
    }

}
