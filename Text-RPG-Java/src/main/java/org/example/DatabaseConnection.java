package org.example;

import java.sql.Connection;

public class DatabaseConnection {
    Connection connection;
    DatabaseConnection instance;

    public DatabaseConnection() {
        instance = new DatabaseConnection();
    }

    public DatabaseConnection get_instance()
    {
        if(instance == null)
        {
            instance = new DatabaseConnection();
        }
        return instance;
    }

}
