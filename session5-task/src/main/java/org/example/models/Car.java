package org.example.models;

import org.example.db.DatabaseOperations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Car implements Vehicle {

    private Long id;
    private String brand;
    private String vehicleType ;

    private  DatabaseOperations dpOps;
    @Autowired
    public Car(DatabaseOperations dpOps)
    {
        this.dpOps = dpOps;
    }
    public Car(Long id , String brand ,String type )
    {
        this.id = id;
        this.brand = brand;
        this.vehicleType = type;

    }
    public Car(){}
    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public String getType() {
        return "Car";
    }
    public void setType(String type)
    {
        this.vehicleType = type;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
    public String getBrand()
    {
        return this.brand;
    }
    public void setBrand(String brand)
    {
        this.brand = brand;
    }
    @Override
    public String toString()
    {
        return  "Car brand = " + this.brand;
    }
}
