package org.example.services;

import org.example.dao.CarDao;
import org.example.dao.VehicleDao;
import org.example.models.Car;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarService implements VehicleDao<Car> {

    private final CarDao carDao;
    public CarService(CarDao carDao)
    {
        this.carDao = carDao;
    }

    @Override
    public void save(Car vehicle) {
        this.carDao.save(vehicle);
    }

    @Override
    public void delete(Long id) {
        this.carDao.delete(id);
    }

    @Override
    public Car update(Car vehicle , Long id) {
        return this.carDao.update(vehicle , id);
    }

    @Override
    public Car searchById(Long id) {
        return this.carDao.searchById(id);
    }

    @Override
    public List<Car> getAll() {
        return this.carDao.getAll();
    }
}
