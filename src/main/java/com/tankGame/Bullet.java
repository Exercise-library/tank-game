package com.tankGame;

import java.awt.*;

public class Bullet {

    private int x, y;
    private static final int speed = 10;
    private Dir dir;
    private boolean live = true;

    private TankFrame tankFrame = null;

    public Bullet(int x, int y, Dir dir, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
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

    public void paint(Graphics g){
        this.move();
        Color color = g.getColor();
        g.setColor(Color.white);
        g.fillOval(x, y, 10, 10);
        g.setColor(color);
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
}
