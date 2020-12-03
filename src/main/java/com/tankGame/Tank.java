package com.tankGame;

import java.awt.*;

public class Tank {

    private int x, y ;
    private static final int speed = 5;
    private Dir dir ;
    private boolean isExercise;
    private boolean live = true;
    private Group group;
    private int width = SourceMag.tankD.getWidth(), height = SourceMag.tankD.getHeight();

    private TankFrame tankFrame;

    public Tank(int x, int y, Dir dir, boolean isExercise, Group group, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.isExercise = isExercise;
        this.group = group;
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
                    width = SourceMag.tankL.getWidth();
                    height = SourceMag.tankL.getHeight();
                    break;
                case RIGTH:
                    x += speed;
                    width = SourceMag.tankR.getWidth();
                    height = SourceMag.tankR.getHeight();
                    break;
                case UP:
                    y -= speed;
                    width = SourceMag.tankU.getWidth();
                    height = SourceMag.tankU.getHeight();
                    break;
                case DOWN:
                    y += speed;
                    width = SourceMag.tankD.getWidth();
                    height = SourceMag.tankD.getHeight();
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
        int bulletWidth = SourceMag.bullet.getWidth(), bulletHeight = SourceMag.bullet.getHeight();
        switch (dir) {
            case UP:
                tankFrame.bullets.add(new Bullet(this.getX()+(SourceMag.tankU.getWidth()/2-bulletWidth/2), this.getY() - 5, this.getDir(), this.group, tankFrame));
                break;
            case DOWN:
                tankFrame.bullets.add(new Bullet(this.getX()+(SourceMag.tankU.getWidth()/2-bulletWidth/2), this.getY() + SourceMag.tankD.getHeight() + 5, this.getDir(), this.group, tankFrame));
                break;
            case LEFT:
                tankFrame.bullets.add(new Bullet(this.getX() - 5, this.getY() + (SourceMag.tankL.getHeight() / 2 - bulletHeight / 2), this.getDir(), this.group, tankFrame));
                break;
            case RIGTH:
                tankFrame.bullets.add(new Bullet(this.getX() + SourceMag.tankR.getWidth() + 5, this.getY() + (SourceMag.tankR.getHeight() / 2 - bulletHeight / 2), this.getDir(), this.group, tankFrame));
                break;
            default:
                break;
        }

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


    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
