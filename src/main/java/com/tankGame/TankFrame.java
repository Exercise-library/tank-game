package com.tankGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends JFrame {

    int x = 100;
    int y = 100;

    public TankFrame(){
        setSize(500,500);
        setVisible(true);
        setTitle("Tank game");
        setResizable(false);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g){
        g.fillRect(x,y,50,50);
    }




}
