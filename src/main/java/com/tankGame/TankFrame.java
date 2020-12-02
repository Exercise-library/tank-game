package com.tankGame;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class TankFrame extends Frame {

    static int GAME_WIDTH = 1800;
    static int GAME_HEIGHT = 800;
    static int ENEMY_TANK_1 = 10;

    Tank tank = new Tank(750, 690, Dir.UP, false, this);
    List<Bullet> bullets = new ArrayList<Bullet>();
    List<Tank> enemyTanks = new ArrayList<Tank>();

    public TankFrame() {
        setSize(GAME_WIDTH, GAME_HEIGHT);
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

        //创建敌人坦克
        for (int i = 1 ; i <= ENEMY_TANK_1; i++) {
            enemyTanks.add(new Tank(i*150, 100, Dir.DOWN, false, this, Color.YELLOW));
        }
    }

    Image offScreenImage = null;
    @Override
    public void update(Graphics g) {
        if(offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.darkGray);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    @Override
    public void paint(Graphics g) {
        tank.paint(g);
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).paint(g);
        }

        //画敌人坦克
        for (int i = 0; i < enemyTanks.size(); i++) {
            enemyTanks.get(i).paint(g);
        }
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
                case KeyEvent.VK_CONTROL:
                    tank.attack();
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
                if (left) tank.setDir(Dir.LEFT);
                if (right) tank.setDir(Dir.RIGTH);
            } else {
                tank.setExercise(false);
            }

        }
    }
}
