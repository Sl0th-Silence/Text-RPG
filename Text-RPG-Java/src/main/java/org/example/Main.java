package org.example;

import com.mysql.cj.xdevapi.JsonParser;
import org.example.Models.Item;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static void main() {
        ArrayList<Item> possible_items = new ArrayList<>();
        ArrayList<String> possible_inputs = new ArrayList<>();
        ArrayList<String> possible_inputs_type = new ArrayList<>();

        Connection connection = DatabaseConnection.get_instance().get_connection();
        //Database
        //Grab items
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM Items");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id =  resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");

                possible_items.add(new Item(id, name, description));
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        //Grab possible inputs
        try{
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT inputs.phrase, phrase_type.type " +
                                                    "FROM inputs " +
                                                    "JOIN phrase_type ON inputs.phrase_type_id = phrase_type.id");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String phrase = resultSet.getString("phrase");
                String type = resultSet.getString("type");

                possible_inputs.add(phrase);
                possible_inputs_type.add(type);
            }

            //We are saving our possible inputs as a parallel array with the input types
            //ie; input(1) ======== input_type(1)... so on
            //Basically, input == possible_input.get(5).
            //What does input_type(5) equal? Go from there
            System.out.println(possible_inputs.get(0) + " " + possible_inputs_type.get(0));

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        //Create window
        main_game game = new main_game(possible_items);
    }
}
