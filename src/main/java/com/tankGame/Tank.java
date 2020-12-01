package com.tankGame;

import java.awt.*;

public class Tank {

    private int x, y ;
    private static final int speed = 20;
    private Dir dir ;
    private boolean isExercise;

    private TankFrame tankFrame;

    public Tank(int x, int y, Dir dir, boolean isExercise, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.isExercise = isExercise;
        this.tankFrame =tankFrame;
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

    /**
     * 坦克自己画自己
     * @param g
     */
    public void paint(Graphics g){
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
        Color color = g.getColor();
        g.setColor(Color.green);
        g.fillRect(x, y, 100, 100);
        g.setColor(color);
    }

    public void attack(){
        tankFrame.bullet = new Bullet(this.getX(), this.getY(), this.getDir());
    }


}
