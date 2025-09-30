package org.example.task2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("applicationContext.xml");
        Car car = container.getBean("car" , Car.class);
        car.saveData();
        Plate plate = container.getBean("plate" , Plate.class);
        plate.saveData();
    }
}
