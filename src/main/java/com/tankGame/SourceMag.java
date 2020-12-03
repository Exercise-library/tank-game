package com.tankGame;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SourceMag {

    public static BufferedImage tankU, tankL, tankD, tankR;
    static {
        try {
            tankU = ImageIO.read(SourceMag.class.getClassLoader().getResourceAsStream("image/tank-u.png"));
            tankL = ImageIO.read(SourceMag.class.getClassLoader().getResourceAsStream("image/tank-l.png"));
            tankD = ImageIO.read(SourceMag.class.getClassLoader().getResourceAsStream("image/tank-d.png"));
            tankR = ImageIO.read(SourceMag.class.getClassLoader().getResourceAsStream("image/tank-r.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
