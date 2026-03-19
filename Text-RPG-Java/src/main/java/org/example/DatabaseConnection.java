package org.example;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DatabaseConnection {
    private Connection connection;
    private static DatabaseConnection instance;
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/rpg_game_database";

    Dotenv dotenv = Dotenv.load();
    String password =  dotenv.get("DATABASE_PASSWORD");

    public DatabaseConnection() {
        try {
             connection = DriverManager.getConnection(DATABASE_URL, "root", password);
        } catch(SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static DatabaseConnection get_instance()
    {
        if(instance == null)
        {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection get_connection()
    {
        try {
            connection = DriverManager.getConnection(DATABASE_URL, "root", password);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return connection;
    }

}
