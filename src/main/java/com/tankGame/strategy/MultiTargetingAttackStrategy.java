package com.tankGame.strategy;

import com.tankGame.TankFrame;
import com.tankGame.enums.Dir;
import com.tankGame.manage.SourceMag;
import com.tankGame.model.Bullet;
import com.tankGame.model.Tank;

/**
 * 向四个方向发射炮弹的攻击策略
 */
public class MultiTargetingAttackStrategy implements AttackStrategy {

    public void attack(Tank tank, TankFrame tankFrame) {
        int bulletWidth = SourceMag.bullet_small.getWidth(), bulletHeight = SourceMag.bullet_small.getHeight();
        tankFrame.getBullets().add(new Bullet(tank.getX()+(SourceMag.tankU.getWidth()/2-bulletWidth/2), tank.getY() - 5, Dir.UP, tank.getGroup(), SourceMag.bullet_small, tankFrame));
        tankFrame.getBullets().add(new Bullet(tank.getX()+(SourceMag.tankU.getWidth()/2-bulletWidth/2), tank.getY() + SourceMag.tankD.getHeight() + 5, Dir.DOWN, tank.getGroup(), SourceMag.bullet_small, tankFrame));
        tankFrame.getBullets().add(new Bullet(tank.getX() - 5, tank.getY() + (SourceMag.tankL.getHeight() / 2 - bulletHeight / 2), Dir.LEFT, tank.getGroup(), SourceMag.bullet_small, tankFrame));
        tankFrame.getBullets().add(new Bullet(tank.getX() + SourceMag.tankR.getWidth() + 5, tank.getY() + (SourceMag.tankR.getHeight() / 2 - bulletHeight / 2), Dir.RIGTH, tank.getGroup(), SourceMag.bullet_small, tankFrame));
    }
}
