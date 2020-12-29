package com.tankGame.model;

import com.tankGame.TankFrame;
import com.tankGame.manage.SourceMag;

import java.awt.*;

/**
 * 爆炸实体
 */
public class Blast {

    private int x, y;
    private int i = 1;

    private TankFrame tankFrame;

    public Blast(int x, int y, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.tankFrame = tankFrame;
    }

    public void paint(Graphics g) {
        g.drawImage(SourceMag.blasts[i], x, y, null);
        i++;
        if (i >= SourceMag.blasts.length)
            tankFrame.getBlasts().remove(this);
    }

}
