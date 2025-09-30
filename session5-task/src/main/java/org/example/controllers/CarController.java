package org.example.controllers;

import org.example.Config.AppConfig;
import org.example.models.Car;
import org.example.services.CarService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class CarController {
    public static void main(String[] args) {
        ApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
        Car car = container.getBean("car" , Car.class);
        car.setBrand("rangerover");
        CarService carService = container.getBean("carService" , CarService.class);
       carService.save(car);
      System.out.println("Car saved with ID: " + car.getId());

//// 2. Update
//       car.setBrand("honda");
//      carService.update(car , (long) 13);
//        System.out.println("Car updated to: " + car.getBrand());
//
//////// 3. Delete
//
//       carService.delete(car.getId());
//      System.out.println("Car deleted with ID: " + car.getId());
        List<Car> cars = carService.getAll();
        for(Car c : cars)
        {
            System.out.println(c);
        }
    }
}
