package org.example.task2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("applicationContext.xml");
        DatabaseOperations dpOps = container.getBean("dpOps" , DatabaseOperations.class);

        ((ConfigurableApplicationContext) container).close();
    }
}
