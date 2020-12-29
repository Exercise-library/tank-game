package com.tankGame.model;

import com.tankGame.enums.Dir;
import com.tankGame.enums.Group;
import com.tankGame.TankFrame;
import com.tankGame.manage.PropertiesMag;
import com.tankGame.manage.SourceMag;
import com.tankGame.strategy.AttackStrategy;

import java.awt.*;

/**
 * 坦克实体
 */
public class Tank {

    private static PropertiesMag propertiesMag = PropertiesMag.getProperMagInstance();

    private int x, y;
    private static final int speed = propertiesMag.getInt("tankSpeed");
    private Dir dir;
    private boolean isExercise;
    private boolean live = true;
    private Group group;
    private int width = SourceMag.tankD.getWidth(), height = SourceMag.tankD.getHeight();
    private Rectangle rectangle = new Rectangle();

    private TankFrame tankFrame;

    public Tank(int x, int y, Dir dir, boolean isExercise, Group group, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.isExercise = isExercise;
        this.group = group;
        this.tankFrame = tankFrame;

        //服装检测依赖
        rectangle.x = x;
        rectangle.y = y;
        rectangle.width = width;
        rectangle.height = height;
    }

    /**
     * 坦克自己画自己
     *
     * @param g
     */
    public void paint(Graphics g) {
        this.move();

        //碰撞检测位置更新
        rectangle.x = x;
        rectangle.y = y;
        switch (dir) {
            case UP:
                g.drawImage(SourceMag.tankU, x, y, null);
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

    public void move() {
        if (this.isExercise && this.isMove()) {
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
    public void attack(AttackStrategy attackStrategy) {
        attackStrategy.attack(this, tankFrame);
    }

    private boolean isMove() {
        switch (dir) {
            case UP:
                if (this.y - 20 <= 0) {
                    return false;
                }
                break;
            case DOWN:
                if (this.y + SourceMag.tankD.getWidth() >= TankFrame.GAME_HEIGHT) {
                    return false;
                }
                break;
            case LEFT:
                if (this.x + 5 <= 0) {
                    return false;
                }
                break;
            case RIGTH:
                if (this.x + SourceMag.tankR.getWidth() + 5 >= TankFrame.GAME_WIDTH) {
                    return false;
                }
                break;
            default:
                break;
        }
        return true;
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

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }
}
