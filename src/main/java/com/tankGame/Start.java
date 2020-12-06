package com.tankGame;

import com.tankGame.enums.Dir;
import com.tankGame.enums.Group;
import com.tankGame.model.Tank;

/**
 * 坦克大战游戏入口
 */
public class Start {

    public static void main(String[] args) throws InterruptedException {
        TankFrame tankFrame = new TankFrame();

        //创建敌人坦克
        for (int i = 1 ; i <= TankFrame.ENEMY_TANK_1; i++) {
            tankFrame.enemyTanks.add(new Tank(i*150, 100, Dir.DOWN, true, Group.BAD, tankFrame));
        }

        while (true) {
            Thread.sleep(50);
            tankFrame.repaint();
        }
    }

}
