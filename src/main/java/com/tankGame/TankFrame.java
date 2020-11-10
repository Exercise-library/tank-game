package com.tankGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends JFrame {

    int x = 100;
    int y = 100;

    public TankFrame(){
        super.setSize(500,500);
        super.setVisible(true);
        super.setTitle("Tank game");
        super.setResizable(false);

        super.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        super.addKeyListener(new MyKeyListener());
    }

    @Override
    public void paint(Graphics g){
        g.fillRect(x,y,50,50);
    }

    class MyKeyListener extends KeyAdapter{

        @Override
        public void keyPressed(KeyEvent e) {
            int keyType = e.getKeyCode();
            switch (keyType){
                case KeyEvent.VK_UP:
                    y -= 10;
                    break;
                case KeyEvent.VK_LEFT:
                    x -= 10;
                    break;
                case KeyEvent.VK_DOWN:
                    y += 10;
                    break;
                case KeyEvent.VK_RIGHT:
                    x += 10;
                    break;
            }
        }

//        @Override
//        public void keyReleased(KeyEvent e) {
//            System.out.println("抬起");
//        }
    }
}
