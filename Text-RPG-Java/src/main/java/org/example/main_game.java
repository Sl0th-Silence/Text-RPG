package org.example;

import org.example.Models.Item;
import org.example.Models.MainChar;
import org.example.Models.Story;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_game extends JFrame {
    private JTextField TFInput;
    private JTextArea TAMain;
    private JTextArea TAOptions;
    private JTextArea TAInput;
    private JPanel Main_Jpanel;

    public main_game() {
        setResizable(false);

        //Map
        int[][] map = new int[15][15];

        setSize(1000, 800);
        // Set colors
        Main_Jpanel.setBackground(Color.BLACK);
        TFInput.setBackground(Color.BLACK);
        TAMain.setBackground(Color.BLACK);
        TAOptions.setBackground(Color.BLACK);
        TAInput.setBackground(Color.BLACK);

        Main_Jpanel.setForeground(Color.WHITE);
        TFInput.setForeground(Color.WHITE);
        TAMain.setForeground(Color.WHITE);
        TAOptions.setForeground(Color.WHITE);
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
                    TAInput.setText(TAInput.getText() + '\n' + TFInput.getText());
                    TFInput.setText("");
                }

                //For input/output

            }
        });
    }
}