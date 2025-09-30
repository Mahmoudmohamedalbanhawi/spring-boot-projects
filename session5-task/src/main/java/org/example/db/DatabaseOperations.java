package org.example.db;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class DatabaseOperations {
    @Value("${db.url}")
    private String url;
    @Value("${db.username}")
    private String userName;
    @Value("${db.password}")
    private String password;

    private Connection connection;

    @PostConstruct
    public void init()
    {
        connectToDataBase();
    }
    @PreDestroy
    public void destroy()
    {
        deconnectToDatabase();
    }
    private void connectToDataBase()
    {
        try {
            if(this.connection == null || this.connection.isClosed())
            {
                this.connection = DriverManager.getConnection(url , userName , password);
                this.connection.setAutoCommit(true);
                System.out.println("connection establish");

            }
        } catch (SQLException e) {
            System.out.println("failed to connect to db" + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    public Connection getConnection()
    {
        try {
            if(this.connection == null || this.connection.isClosed())
            {
                connectToDataBase();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return this.connection;
    }
    private void deconnectToDatabase()
    {
        if (this.connection != null) {
            try {
                if (!this.connection.isClosed()) {
                    this.connection.close();
                    System.out.println("Connection closed.");
                }
            } catch (SQLException e) {
                System.err.println("Error closing connection: " + e.getMessage());
            }
        }

    }
}
