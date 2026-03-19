package org.example;

import org.example.Models.Item;
import org.example.Models.MainChar;
import org.example.Models.Story;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class main_game extends JFrame {
    private JTextField TFInput;
    private JTextArea TAMain;
    private JTextArea TAInput;
    private JPanel Main_Jpanel;

    public main_game(ArrayList<Item> i_possible_items) {
        setResizable(false);
        //Map
        int[][] map = new int[15][15];

        ArrayList<Item> possible_items = i_possible_items;

        setSize(1000, 800);
        // Set colors
        Main_Jpanel.setBackground(Color.BLACK);
        TFInput.setBackground(Color.BLACK);
        TAMain.setBackground(Color.BLACK);
        TAInput.setBackground(Color.BLACK);

        Main_Jpanel.setForeground(Color.WHITE);
        TFInput.setForeground(Color.WHITE);
        TAMain.setForeground(Color.WHITE);
        TAInput.setForeground(Color.WHITE);

        setContentPane(Main_Jpanel);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        //Focus on type input window
        EventQueue.invokeLater(() -> TFInput.requestFocusInWindow());

        //Title Menu
        Story story = new Story();
        TAMain.setText(story.title_screen(0));

        TFInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(TFInput.getText().isEmpty() || TFInput.getText().isBlank())
                {
                    return;
                }
                else {
                    String input = TFInput.getText().toLowerCase();
                    System.out.println(input);

                    TFInput.setText("");

                    if (Objects.equals(input, "show all items") ||
                        Objects.equals(input, "show all"))
                    {
                        //Show all items for TESTING ONLY
                        for (Item item : possible_items) {
                            TAInput.append(item.toString());
                        }
                    }
                    else
                    {
                        System.out.println("'" + input + "'");
                    }
                    input = "";
                }

                //For input/output

            }
        });
    }
}