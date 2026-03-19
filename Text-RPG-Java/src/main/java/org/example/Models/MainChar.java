package org.example.Models;

import java.util.ArrayList;

public class MainChar {
    String name;
    String class_name;

    int level = 1;
    int inventory_count;
    int inventory_capacity;
    int[][] world_location;

    float current_xp;
    float needed_xp;

    ArrayList<Item> inventory;

    //Construct
    public MainChar(String name, String class_name, int[][] location)
    {
        this.name = name;
        this.class_name = class_name;

        this.inventory_count = 0;
        this.inventory_capacity = 25;

        this.world_location = location;

        //Initialize inventory
        inventory = new ArrayList<>();
    }

    public String pickup_item(Item item)
    {
        if(inventory_count == inventory_capacity)
        {
            return "Your inventory is already full!";
        }

        inventory.add(item);
        return "Added " + item.name + " to inventory!";
    }

    //Setters
    public void set_world_location(int[][] location)
    {
        this.world_location = location;
    }
    //Getters

}
