package org.example.dao;

import org.example.db.DatabaseOperations;
import org.example.models.Bike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class BikeDao implements VehicleDao<Bike> {
    private DatabaseOperations dpOps;
    @Autowired
    public BikeDao(DatabaseOperations dpOps)
    {
        this.dpOps = dpOps;
    }
    public void save(Bike bike)
    {
        String sql = "INSERT INTO vehicles (vehicle_type , brand) values (?,?)";
        try(PreparedStatement ps = dpOps.getConnection().prepareStatement(sql , Statement.RETURN_GENERATED_KEYS))

        {
            ps.setString(1 ,bike.getType() );
            ps.setString(2 , bike.getBrand());
            ps.executeUpdate();
            try(ResultSet rs = ps.getGeneratedKeys())
            {
                if(rs.next()) bike.setId(rs.getLong(1));
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
    public Bike update(Bike bike , Long id)
    {
        String sql = "update vehicles set brand = ? where id = ? ";
        try(PreparedStatement ps = dpOps.getConnection().prepareStatement(sql)) {
            ps.setString(1 , bike.getBrand());
            ps.setLong(2 , id);
            ps.executeUpdate();
            return bike;
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
    public Bike searchById(Long id)
    {
        String sql = "select * from vehicles where id = ? and vehicle_type = 'Bike'";
        try(PreparedStatement ps = dpOps.getConnection().prepareStatement(sql))
        {
            ps.setLong(1,id);
            try(ResultSet rs = ps.executeQuery() )
            {
                if(rs.next())
                {
                    return mapRowToBike(rs);
                }
            }
        }catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return  null;
    }
    public List<Bike> getAll()
    {
        List<Bike> bikes = new ArrayList<>();
        String sql = "select * from vehicles where vehicle_type = 'Bike'";
        try(Statement st = dpOps.getConnection().createStatement())
        {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
            {

                bikes.add(mapRowToBike(rs));
            }

        }catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return bikes;

    }
    private Bike mapRowToBike(ResultSet rs) throws SQLException
    {
        Bike bike = new Bike();
        bike.setId(rs.getLong("id"));
        bike.setBrand(rs.getString("brand"));
        return bike;
    }
}
