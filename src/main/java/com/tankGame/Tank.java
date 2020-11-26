package com.tankGame;

import java.awt.*;

public class Tank {

    private int x, y ;
    private static final int speed = 20;
    private Dir dir ;

    public Tank(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
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

    /**
     * 坦克自己画自己
     * @param g
     */
    public void paint(Graphics g){
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
        g.fillRect(x, y, 100, 100);
    }


}
