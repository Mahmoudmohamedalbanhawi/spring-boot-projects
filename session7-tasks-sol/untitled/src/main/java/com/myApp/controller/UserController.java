package com.myApp.controller;

import com.myApp.models.User;
import com.myApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping("/userForm")
    public String userFormPage()
    {
        return "userForm";
    }
    @RequestMapping("/submitForm")
    public ModelAndView submitForm(@ModelAttribute("user")User user)
    {
        userService.save(user);
        ModelAndView mv = new ModelAndView("confirm");

        mv.addObject("user", user);
        mv.addObject("message", " Data submitted successfully!");
        return mv;
    }
}
