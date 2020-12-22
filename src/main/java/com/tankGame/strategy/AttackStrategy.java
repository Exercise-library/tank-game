package com.tankGame.strategy;

import com.tankGame.TankFrame;
import com.tankGame.model.Tank;

/**
 * 坦克攻击策略
 */
public interface AttackStrategy {

    void attack(Tank tank, TankFrame tankFrame);

}
