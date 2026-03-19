package org.example;

import org.example.Models.Item;
import org.example.Models.Story;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class main_game extends JFrame {
    private JTextField TFInput;
    private JTextArea TAMain;
    private JTextArea TALog;
    private JPanel Main_Jpanel;

    public main_game(ArrayList<Item> possible_items) {
        setResizable(false);
        //Map
        int[][] map = new int[15][15];

        setSize(1000, 800);
        // Set colors
        Main_Jpanel.setBackground(Color.BLACK);
        TFInput.setBackground(Color.BLACK);
        TAMain.setBackground(Color.BLACK);
        TALog.setBackground(Color.BLACK);

        Main_Jpanel.setForeground(Color.WHITE);
        TFInput.setForeground(Color.WHITE);
        TAMain.setForeground(Color.WHITE);
        TALog.setForeground(Color.WHITE);

        setContentPane(Main_Jpanel);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        //Title Menu
        Story story = new Story();
        TAMain.setText(story.title_screen(0));

        //Listener <Enter>
        TFInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(TFInput.getText().isEmpty() || TFInput.getText().isBlank())
                {
                    return;
                }
                else {
                    String input = TFInput.getText();
                    TALog.setText(TALog.getText().concat("\n>> " + input));
                    input = TFInput.getText().toLowerCase();
                    TFInput.setText("");

                    if (Objects.equals(input, "show all items") ||
                        Objects.equals(input, "show all"))
                    {
                        //Show all items for TESTING ONLY
                        for (Item item : possible_items) {
                            TALog.append(item.toString());
                        }
                    }
                    else if (Objects.equals(input, "clear"))
                    {
                        TALog.setText("");
                    }
                    input = "";
                }

                //For input/output

            }
        });
    }
}