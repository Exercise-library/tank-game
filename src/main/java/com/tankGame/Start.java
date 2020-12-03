package com.tankGame;

import java.awt.*;

/**
 * 坦克大战游戏入口
 */
public class Start {

    public static void main(String[] args) throws InterruptedException {
        TankFrame tankFrame = new TankFrame();

        //创建敌人坦克
        for (int i = 1 ; i <= TankFrame.ENEMY_TANK_1; i++) {
            tankFrame.enemyTanks.add(new Tank(i*150, 100, Dir.DOWN, false, Group.BAD, tankFrame));
        }

        while (true) {
            Thread.sleep(50);
            tankFrame.repaint();
        }
    }

}
