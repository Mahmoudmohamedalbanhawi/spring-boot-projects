package org.example.dao;

import org.example.db.DatabaseOperations;
import org.example.models.Plane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class PlaneDao implements VehicleDao<Plane> {
    private DatabaseOperations dpOps;
    @Autowired
    public PlaneDao(DatabaseOperations dpOps)
    {
        this.dpOps = dpOps;
    }
    public void save(Plane plane)
    {
        String sql = "INSERT INTO vehicles (vehicle_type , brand) values (?,?)";
        try(PreparedStatement ps = dpOps.getConnection().prepareStatement(sql , Statement.RETURN_GENERATED_KEYS))

        {
            ps.setString(1 ,plane.getType() );
            ps.setString(2 , plane.getBrand());
            ps.executeUpdate();
            try(ResultSet rs = ps.getGeneratedKeys())
            {
                if(rs.next()) plane.setId(rs.getLong(1));
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
    public Plane update(Plane plane , Long id)
    {
        String sql = "update vehicles set brand = ? where id = ? ";
        try(PreparedStatement ps = dpOps.getConnection().prepareStatement(sql)) {
            ps.setString(1 , plane.getBrand());
            ps.setLong(2 , id);
            ps.executeUpdate();
            return plane;
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
    public Plane searchById(Long id)
    {
        String sql = "select * from vehicles where id = ? and vehicle_type = 'Bike'";
        try(PreparedStatement ps = dpOps.getConnection().prepareStatement(sql))
        {
            ps.setLong(1,id);
            try(ResultSet rs = ps.executeQuery() )
            {
                if(rs.next())
                {
                    return mapRowToPlane(rs);
                }
            }
        }catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return  null;
    }
    public List<Plane> getAll()
    {
        List<Plane> planes = new ArrayList<>();
        String sql = "select * from vehicles where vehicle_type = 'Bike'";
        try(Statement st = dpOps.getConnection().createStatement())
        {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
            {

                planes.add(mapRowToPlane(rs));
            }

        }catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return planes;

    }
    private Plane mapRowToPlane(ResultSet rs) throws SQLException
    {
        Plane plane = new Plane();
        plane.setId(rs.getLong("id"));
        plane.setBrand(rs.getString("brand"));
        return plane;
    }
}
