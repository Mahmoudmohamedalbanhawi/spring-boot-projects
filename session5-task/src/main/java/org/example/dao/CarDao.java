package org.example.dao;

import org.example.db.DatabaseOperations;
import org.example.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class CarDao implements VehicleDao<Car> {

    private final DatabaseOperations dpOps;
    @Autowired
    public CarDao(DatabaseOperations dpOps)
    {
        this.dpOps = dpOps;
    }
    @Override
    public void save(Car car)
    {
        String sql = "INSERT INTO vehicles (vehicle_type , brand) values (?,?)";
        try(PreparedStatement ps = dpOps.getConnection().prepareStatement(sql , Statement.RETURN_GENERATED_KEYS))

        {
            ps.setString(1 ,car.getType() );
            ps.setString(2 , car.getBrand());
            ps.executeUpdate();
            try(ResultSet rs = ps.getGeneratedKeys())
            {
                if(rs.next()) car.setId(rs.getLong(1));
            }
        }catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

    }
    public void delete(Long id)
    {
        String sql = "delete from vehicles where id = ?";
        try(PreparedStatement ps = dpOps.getConnection().prepareStatement(sql)) {
         ps.setLong(1 , id);
         ps.executeUpdate();
        }catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
    public Car update(Car car , Long id)
    {
        String sql = "update vehicles set brand = ? where id = ? ";
        try(PreparedStatement ps = dpOps.getConnection().prepareStatement(sql)) {
            ps.setString(1 , car.getBrand());
            ps.setLong(2 , id);
            ps.executeUpdate();
            return car;
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
    public Car searchById(Long id)
    {
        String sql = "select * from vehicles where id = ? and vehicle_type = 'Car'";
        try(PreparedStatement ps = dpOps.getConnection().prepareStatement(sql))
        {
            ps.setLong(1,id);
            try(ResultSet rs = ps.executeQuery() )
            {
                if(rs.next())
                {
                    return mapRowToCar(rs);
                }
            }
        }catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return  null;
    }
    public List<Car> getAll()
    {
        List<Car> cars = new ArrayList<>();
        String sql = "select * from vehicles where vehicle_type = 'Car'";
        try(Statement st = dpOps.getConnection().createStatement())
        {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
            {

                cars.add(mapRowToCar(rs));
            }

        }catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return cars;

    }
    private Car mapRowToCar(ResultSet rs) throws SQLException
    {
        Car car = new Car();
        car.setId(rs.getLong("id"));
        car.setBrand(rs.getString("brand"));
        return car;
    }
}
