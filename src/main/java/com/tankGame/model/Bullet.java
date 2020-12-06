package com.tankGame.model;

import com.tankGame.enums.Dir;
import com.tankGame.enums.Group;
import com.tankGame.TankFrame;
import com.tankGame.manage.PropertiesMag;
import com.tankGame.manage.SourceMag;

import java.awt.*;

/**
 * 子弹实体
 */
public class Bullet {

    private static PropertiesMag propertiesMag = PropertiesMag.getProperMagInstance();

    private int x, y;
    private static final int speed = propertiesMag.getInt("bulletSpeed");
    private Dir dir;
    private boolean live = true;
    private static final int width = propertiesMag.getInt("bulletWidth"), height = propertiesMag.getInt("bulletHeight");
    private Group group;
    private Rectangle rectangle = new Rectangle();

    private TankFrame tankFrame = null;

    public Bullet(int x, int y, Dir dir, Group group,TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tankFrame = tankFrame;

        //更新子弹位置
        rectangle.x = x;
        rectangle.y = y;
        rectangle.height = height;
        rectangle.width = width;
    }

    public void paint(Graphics g){
        this.move();
        rectangle.x = x;
        rectangle.y = y;
        g.drawImage(SourceMag.bullet, x, y, null);
        //子弹死亡检测
        if (!this.live) {
            tankFrame.getBullets().remove(this);
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
        if (this.group == tank.getGroup()) {
            return;
        }

        if (this.rectangle.intersects(tank.getRectangle())) {
            this.live = false;
            tank.setLive(false);
            //坦克被击毁发生爆炸
            tankFrame.getBlasts().add(new Blast(tank.getX(), tank.getY(), tankFrame));
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

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }
}
