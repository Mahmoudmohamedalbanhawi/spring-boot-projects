package org.example.models;

import org.example.db.DatabaseOperations;
import org.example.vehicles.VehicleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Plane implements Vehicle{
    private Long id ;
    private String brand;
    private String type;
    private  DatabaseOperations dbOps;
    @Override
    public Long getId() {
        return this.id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String getType() {
        return "Plane";
    }




    @Override
    public void setId(Long id) {
        this.id = id ;
    }
    @Autowired
    public void setDbOps(DatabaseOperations dbOps)
    {
        this.dbOps = dbOps;

    }
}
