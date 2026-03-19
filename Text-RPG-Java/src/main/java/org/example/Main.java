package org.example;

import org.example.Models.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    static void main() {
        ArrayList<Item> possible_items = new ArrayList<>();

        Connection connection = DatabaseConnection.get_instance().get_connection();
        //Database
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

        //Create window
        main_game game = new main_game(possible_items);
    }
}
