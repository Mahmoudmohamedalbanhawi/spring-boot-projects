package com.myApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.temporal.ChronoUnit;

@Controller
public class HomeController
{


    @RequestMapping("/")
    public String showHomePage()
    {
        return "formPage";
    }


    @RequestMapping("/ageForm")
    public String ageForm(HttpServletRequest request , Model model)
    {
        String year = request.getParameter("year");
        String month = request.getParameter("month");
        String day = request.getParameter("day");
        LocalDate today = LocalDate.now();
        long yearDiff = today.getYear() - Integer.parseInt(year);
        long monthDiff = today.getMonthValue() - Integer.parseInt(month);
        long dayDiff = today.getDayOfMonth() - Integer.parseInt(day);
        if(dayDiff < 0)
        {
            monthDiff--;
            dayDiff+= today.lengthOfMonth();
        }
        if(monthDiff <0)
        {
            yearDiff--;
            monthDiff+=12;
        }
        model.addAttribute("year" , yearDiff);
        model.addAttribute("month" , monthDiff);
        model.addAttribute("day" , dayDiff);
        return  "resultPage";
    }

}
