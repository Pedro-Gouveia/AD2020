package org.example;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class guiController {
    private JPanel panel1;
    private JButton alterarButton;
    private JButton ativarButton;
    private JTextArea logArea;
    private JSlider distanceSlider;

    public guiController() {


        alterarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        ativarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        distanceSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

            }
        });

    }

    /*
    public static void main (String[] args){
        JFrame frame = new guiController();
        frame.setVisible(true);
    }
    */
}
