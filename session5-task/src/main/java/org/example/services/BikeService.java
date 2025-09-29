package org.example.services;

import org.example.dao.BikeDao;
import org.example.dao.VehicleDao;
import org.example.models.Bike;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class BikeService implements VehicleDao<Bike> {
    private final BikeDao bikeDao;
    public BikeService(BikeDao bikeDao)
    {
        this.bikeDao = bikeDao;
    }

    @Override
    public void save(Bike vehicle) {
        this.bikeDao.save(vehicle);
    }

    @Override
    public void delete(Long id) {
        this.bikeDao.delete(id);
    }

    @Override
    public Bike update(Bike vehicle, Long id) {
        return this.bikeDao.update(vehicle , id);
    }

    @Override
    public Bike searchById(Long id) {
        return this.bikeDao.searchById(id);
    }

    @Override
    public List<Bike> getAll() {
        return this.bikeDao.getAll();
    }
}
