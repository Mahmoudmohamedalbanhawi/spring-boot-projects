package com.myApp.controller;

import com.myApp.model.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class HomeController
{


    @RequestMapping("/")
    public String showHomePage(Model model)
    {
        model.addAttribute("userModel" , new UserModel());
        return "formPage";
    }

    @RequestMapping("/formData")
    public String formData(@ModelAttribute("userModel") UserModel userModel , Model model)
    {
        model.addAttribute("userData" , userModel);
        return "resultPage";
    }


}