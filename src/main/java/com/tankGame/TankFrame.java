package com.tankGame;

import com.tankGame.enums.Dir;
import com.tankGame.enums.Group;
import com.tankGame.model.Blast;
import com.tankGame.model.Bullet;
import com.tankGame.model.Tank;
import com.tankGame.strategy.DefaultAttackStrategy;
import com.tankGame.strategy.NBombAttackStrategy;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TankFrame extends Frame {

    public static int GAME_WIDTH = 1800;
    public static int GAME_HEIGHT = 800;
    public static int ENEMY_TANK_1 = 10;

    Tank tank = new Tank(750, 690, Dir.UP, false, Group.GOOD, this);
    List<Bullet> bullets = new ArrayList<Bullet>();
    List<Tank> enemyTanks = new ArrayList<Tank>();
    List<Blast> blasts = new ArrayList<Blast>();

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
    }

    Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
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
        g.drawString("子弹剩余数量：" + bullets.size(), 50, 50);
        g.drawString("敌军剩余坦克：" + enemyTanks.size(), 50, 70);
        tank.paint(g);
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).paint(g);
        }

        //检测子弹与坦克是否发生碰撞
        for (int i = 0; i < bullets.size(); i++) {
            for (int j = 0; j < enemyTanks.size(); j++) {
                bullets.get(i).detection(enemyTanks.get(j));
            }
        }

        //画敌人坦克
        for (int i = 0; i < enemyTanks.size(); i++) {
            if (enemyTanks.get(i).isLive()) {
                enemyTanks.get(i).paint(g);

                //活着的敌军坦克增加发射子弹的操作
                Random ta = new Random();
                if (ta.nextInt(100) >= 98) {
                    enemyTanks.get(i).attack(new DefaultAttackStrategy());
                }

                Random ta2 = new Random();
                int tempFir = ta2.nextInt(1000);
                if (tempFir >= 990) {
                    switch (tempFir % 4) {
                        case 0:
                            enemyTanks.get(i).setDir(Dir.UP);
                            break;
                        case 1:
                            enemyTanks.get(i).setDir(Dir.LEFT);
                            break;
                        case 2:
                            enemyTanks.get(i).setDir(Dir.DOWN);
                            break;
                        case 3:
                            enemyTanks.get(i).setDir(Dir.RIGTH);
                            break;
                        default:
                            break;
                    }
                }

            } else {
                enemyTanks.remove(i);
            }
        }

        //画爆炸动画
        for (int i = 0; i < blasts.size(); i++) {
            blasts.get(i).paint(g);
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
                    tank.attack(new NBombAttackStrategy());
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

    public List<Bullet> getBullets() {
        return bullets;
    }

    public void setBullets(List<Bullet> bullets) {
        this.bullets = bullets;
    }

    public List<Tank> getEnemyTanks() {
        return enemyTanks;
    }

    public void setEnemyTanks(List<Tank> enemyTanks) {
        this.enemyTanks = enemyTanks;
    }

    public List<Blast> getBlasts() {
        return blasts;
    }

    public void setBlasts(List<Blast> blasts) {
        this.blasts = blasts;
    }
}
