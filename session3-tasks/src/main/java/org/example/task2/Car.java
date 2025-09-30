package org.example.task2;

public class Car implements Vehicle{

    private DatabaseConfig databaseConfig;
    public Car(DatabaseConfig databaseConfig)
    {
        this.databaseConfig = databaseConfig;
    }

    @Override
    public void saveData() {
        System.out.println("logging " +  " userName : " + databaseConfig.getUserName() + " dataBase url " + databaseConfig.getUrl());
        System.out.println("car vehicle inserted");
    }

}
