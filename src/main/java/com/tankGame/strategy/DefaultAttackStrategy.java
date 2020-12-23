package com.tankGame.strategy;

import com.tankGame.TankFrame;
import com.tankGame.manage.SourceMag;
import com.tankGame.model.Bullet;
import com.tankGame.model.Tank;

/**
 * 默认坦克攻击的实现策略
 */
public class DefaultAttackStrategy implements AttackStrategy {

    public void attack(Tank tank, TankFrame tankFrame) {
        int bulletWidth = SourceMag.bullet_small.getWidth(), bulletHeight = SourceMag.bullet_small.getHeight();
        switch (tank.getDir()) {
            case UP:
                tankFrame.getBullets().add(new Bullet(tank.getX()+(SourceMag.tankU.getWidth()/2-bulletWidth/2), tank.getY() - 5, tank.getDir(), tank.getGroup(), SourceMag.bullet_small, tankFrame));
                break;
            case DOWN:
                tankFrame.getBullets().add(new Bullet(tank.getX()+(SourceMag.tankU.getWidth()/2-bulletWidth/2), tank.getY() + SourceMag.tankD.getHeight() + 5, tank.getDir(), tank.getGroup(), SourceMag.bullet_small, tankFrame));
                break;
            case LEFT:
                tankFrame.getBullets().add(new Bullet(tank.getX() - 5, tank.getY() + (SourceMag.tankL.getHeight() / 2 - bulletHeight / 2), tank.getDir(), tank.getGroup(), SourceMag.bullet_small, tankFrame));
                break;
            case RIGTH:
                tankFrame.getBullets().add(new Bullet(tank.getX() + SourceMag.tankR.getWidth() + 5, tank.getY() + (SourceMag.tankR.getHeight() / 2 - bulletHeight / 2), tank.getDir(), tank.getGroup(), SourceMag.bullet_small, tankFrame));
                break;
            default:
                break;
        }
    }
}
