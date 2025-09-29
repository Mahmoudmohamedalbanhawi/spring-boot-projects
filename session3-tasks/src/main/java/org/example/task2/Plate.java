package org.example.task2;

public class Plate implements Vehicle{
    private DatabaseConfig databaseConfig;
    public Plate(DatabaseConfig databaseConfig)
    {
        this.databaseConfig = databaseConfig;
    }
    @Override
    public void saveData() {
        System.out.println("logging " +  " userName : " + databaseConfig.getUserName() + " dataBase url " + databaseConfig.getUrl());
        System.out.println("plate vehicle inserted");
    }
}
