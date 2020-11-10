package com.tankGame;

/**
 * 坦克大战游戏入口
 */
public class Start {

    public static void main(String[] args) throws InterruptedException {
        TankFrame tankFrame = new TankFrame();

        while (true) {
            Thread.sleep(50);
            tankFrame.repaint();
        }
    }

}
