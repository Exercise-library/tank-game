package com.tankGame;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static com.tankGame.Dir.LEFT;
import static com.tankGame.Dir.RIGTH;

public class TankFrame extends Frame {

    Tank tank = new Tank(100, 100, Dir.UP, false);

    public TankFrame() {
        setSize(500, 500);
        setVisible(true);
        setTitle("Tank game");
        setResizable(false);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        addKeyListener(new MyKeyListener());
    }

    @Override
    public void paint(Graphics g) {
        tank.paint(g);
    }

    class MyKeyListener extends KeyAdapter {

        boolean down = false;
        boolean up = false;
        boolean left = false;
        boolean right = false;

        @Override
        public void keyPressed(KeyEvent e) {
            int keyType = e.getKeyCode();
            switch (keyType) {
                case KeyEvent.VK_UP:
                    up = true;
                    break;
                case KeyEvent.VK_LEFT:
                    left = true;
                    break;
                case KeyEvent.VK_DOWN:
                    down = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    right = true;
                    break;
                default:
                    break;
            }
            setTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int keyType = e.getKeyCode();
            switch (keyType) {
                case KeyEvent.VK_UP:
                    up = false;
                    break;
                case KeyEvent.VK_LEFT:
                    left = false;
                    break;
                case KeyEvent.VK_DOWN:
                    down = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    right = false;
                    break;
                default:
                    break;
            }
            setTankDir();
        }

        public void setTankDir() {
            if (up || down || left || right) {
                tank.setExercise(true);
                if (up) tank.setDir(Dir.UP);
                if (down) tank.setDir(Dir.DOWN);
                if (left) tank.setDir(LEFT);
                if (right) tank.setDir(RIGTH);
            } else {
                tank.setExercise(false);
            }

        }
    }
}
