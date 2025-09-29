package org.example.services;

import org.example.dao.PlaneDao;
import org.example.dao.VehicleDao;
import org.example.models.Plane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class PlaneService implements VehicleDao<Plane> {
    private final PlaneDao planeDao;
    @Autowired
    public PlaneService(PlaneDao planeDao)
    {
        this.planeDao = planeDao;
    }
    @Override
    public void save(Plane vehicle) {
        this.planeDao.save(vehicle);
    }

    @Override
    public void delete(Long id) {
        this.planeDao.delete(id);
    }

    @Override
    public Plane update(Plane vehicle, Long id) {
        return this.planeDao.update(vehicle , id);
    }

    @Override
    public Plane searchById(Long id) {
        return this.planeDao.searchById(id);
    }

    @Override
    public List<Plane> getAll() {
        return this.planeDao.getAll();
    }
}
