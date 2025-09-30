package org.example.controllers;

import org.example.Config.AppConfig;
import org.example.models.Bike;
import org.example.services.BikeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BikeController {
    public static void main(String[] args) {
        ApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
        Bike bike1 = container.getBean("bike" , Bike.class);
        bike1.setBrand("Trek");
        BikeService bikeService = container.getBean("bikeService" , BikeService.class);
        bikeService.save(bike1);
    }
}
