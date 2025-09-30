package org.example.task1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("applicationContext.xml");
        Circle circle = container.getBean("circle" , Circle.class);
        circle.draw2d();
        circle.draw3d();
        Square square = container.getBean("square" , Square.class);
        square.draw2d();
        square.draw3d();

    }
}
