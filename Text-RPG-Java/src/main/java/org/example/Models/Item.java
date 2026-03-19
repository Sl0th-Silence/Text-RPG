package org.example.Models;

public class Item {
    int id;
    String name;
    String description;
    public Item(int id, String name, String description)
    {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String toString()
    {
        return "\nItem: " + this.name + "\nDescription: " + this.description + '\n';
    }
}
