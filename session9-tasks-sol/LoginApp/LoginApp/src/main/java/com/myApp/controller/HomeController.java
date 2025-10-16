package com.myApp.controller;

import com.myApp.model.UserModel;
import com.myApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController
{
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String showHomePage(Model model)
    {
        model.addAttribute("userModel" , new UserModel());
        return "formPage";
    }

    @RequestMapping("/processForm")
    public String submitForm(@Valid @ModelAttribute("userModel") UserModel userModel , BindingResult result, Model model)
    {

        if(result.hasErrors())
            return "formPage";



        userService.save(userModel);
       model.addAttribute("userModelResult" , userModel);


        return "resultPage";
    }


    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        StringTrimmerEditor editor = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class , editor);
    }
}