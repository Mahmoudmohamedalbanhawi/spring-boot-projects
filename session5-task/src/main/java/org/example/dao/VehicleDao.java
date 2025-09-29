package org.example.dao;

import java.util.List;

public interface VehicleDao<T> {

    void save(T vehicle);
    void delete(Long id);
    T update(T vehicle , Long id);
    T searchById(Long id);
    List<T> getAll();
}
