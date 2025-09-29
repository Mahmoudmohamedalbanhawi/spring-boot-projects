package org.example.controllers;

import org.example.Config.AppConfig;
import org.example.models.Plane;
import org.example.services.PlaneService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PlaneController {
    public static void main(String[] args) {
        ApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
        Plane plane1 = container.getBean("plane" , Plane.class);
        plane1.setBrand("Boeing");
        PlaneService planeService = container.getBean("planeService" , PlaneService.class);
        planeService.save(plane1);
    }
}
