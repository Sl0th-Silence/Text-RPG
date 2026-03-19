package org.example.Models;

import java.util.ArrayList;

public class Story {
    //This handles the current position in the story and what is happening
    ArrayList<String> text_log;

    public Story()
    {
        text_log = new ArrayList<>();
    }

    public String title_screen(int string_id)
    {
        text_log.add("Welcome to the story!");
        text_log.add("Please enter your name:");

        return text_log.get(string_id);
    }
}
