package com.tankGame;

import java.awt.*;

public class Tank {

    private int x, y ;
    private static final int speed = 20;
    private Dir dir ;
    private boolean isExercise;
    private Color color = Color.GREEN;
    private boolean live = true;
    private int width = 100, height = 100;
//    private int width = SourceMag.tankD.getWidth(), height = SourceMag.tankD.getHeight();

    private TankFrame tankFrame;

    public Tank(int x, int y, Dir dir, boolean isExercise, TankFrame tankFrame, Color color) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.isExercise = isExercise;
        this.tankFrame =tankFrame;
        this.color = color;
    }

    public Tank(int x, int y, Dir dir, boolean isExercise, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.isExercise = isExercise;
        this.tankFrame =tankFrame;
    }

    /**
     * 坦克自己画自己
     * @param g
     */
    public void paint(Graphics g){
        this.move();
        switch (dir) {
            case UP:
                g.drawImage(SourceMag.tankU, x, y,  null);
                break;
            case LEFT:
                g.drawImage(SourceMag.tankL, x, y, null);
                break;
            case DOWN:
                g.drawImage(SourceMag.tankD, x, y, null);
                break;
            case RIGTH:
                g.drawImage(SourceMag.tankR, x, y, null);
                break;
            default:
                break;
        }
    }

    public void move(){
        if (this.isExercise) {
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
        }
    }

    /**
     * 发射子弹
     */
    public void attack(){
        tankFrame.bullets.add(new Bullet(this.getX(), this.getY(), this.getDir(), tankFrame));
    }

    public boolean isExercise() {
        return isExercise;
    }

    public void setExercise(boolean exercise) {
        isExercise = exercise;
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

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }
}
