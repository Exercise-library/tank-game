package com.tankGame;

import java.awt.*;

public class Bullet {

    private int x, y;
    private static final int speed = 10;
    private Dir dir;
    private boolean live = true;
    private static final int width = 5, height = 5;

    private TankFrame tankFrame = null;

    public Bullet(int x, int y, Dir dir, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
    }

    public void paint(Graphics g){
        this.move();
        g.drawImage(SourceMag.bullet, x, y, null);
        //子弹死亡检测
        if (!this.live) {
            tankFrame.bullets.remove(this);
        }
    }

    public void move(){
        switch (dir) {
            case LEFT:
                x -= speed;
                break;
            case RIGTH:
                x += speed;
                break;
            case UP:
                y -= speed;
                break;
            case DOWN:
                y += speed;
                break;
            default:
                break;
        }
        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) {
            this.live = false;
        }
    }

    /**
     * 碰撞检测
     * @param tank
     */
    public void detection(Tank tank) {
        Rectangle rectangleBullet = new Rectangle(this.x, this.y, Bullet.width, Bullet.height);
        Rectangle rectangleEmenyTank = new Rectangle(tank.getX(), tank.getY(), tank.getWidth(), tank.getHeight());

        if (rectangleBullet.intersects(rectangleEmenyTank)) {
            this.live = false;
            tank.setLive(false);
        }

    }


    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
