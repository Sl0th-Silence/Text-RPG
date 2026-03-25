package org.example.Models;

import org.example.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

// This is a class that handles all the inputs from the user
public class InputOutput {
    HashMap<Integer/*phrase type id*/,
            String/*The phrase*/> inputs = new HashMap<>(); //Hold inputs
    Connection connection;

    //Constructor will populate hashmap on creation
    public InputOutput() {
        connection = DatabaseConnection.get_instance().get_connection();
        try{
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM inputs");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String phrase =  resultSet.getString("phrase");
                int phraseType =  resultSet.getInt("phrase_type_id");

                inputs.put(phraseType, phrase);
            }
        } catch(SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public HashMap<Integer, String> getInputs()
    {
        return this.inputs;
    }
}
