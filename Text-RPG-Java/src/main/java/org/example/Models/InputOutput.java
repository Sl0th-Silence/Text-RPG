package org.example.Models;

import org.example.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

// This is a class that handles all the inputs from the user
public class InputOutput {
    ArrayList<String> inputsPhrase = new ArrayList<>(); //Hold inputs
    ArrayList<Integer> inputsKey = new ArrayList<>();
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

                inputsKey.add(phraseType);
                inputsPhrase.add(phrase);
            }
        } catch(SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    //getter
    public ArrayList<String> getInputsPhrase()
    {
        return this.inputsPhrase;
    }

    //Check if input exists and returns the input and input type
    public ArrayList<String> checkInput(String i_phrase)
    {
        ArrayList<String> o_phrase = new ArrayList<>();
        System.out.println("Input phrase: " + i_phrase);
        for(int ctr = 0; ctr < inputsKey.size(); ctr++)
            if(i_phrase.equals(inputsPhrase.get(ctr)))
            {
                System.out.println("Input phrase is correct");
                o_phrase.add(inputsPhrase.get(ctr));
                break;
            }
            else
            {
                System.out.println(i_phrase + " does not equal " + inputsPhrase.get(ctr));
            }
        return o_phrase;
    }
}