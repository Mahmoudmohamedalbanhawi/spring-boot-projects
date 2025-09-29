package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("applicationContext.xml");
        Circle circle = container.getBean("circle" , Circle.class);
        circle.setRadius(10);
        circle.getArea();
        System.out.println(circle.toString());
        Rectangle rectangle = container.getBean("rectangle" , Rectangle.class);
        rectangle.setLength(10);
        rectangle.setWidth(20);
        rectangle.getArea();
        System.out.println(rectangle.toString());
    }
}