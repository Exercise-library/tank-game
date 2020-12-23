package com.tankGame.manage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SourceMag {

    public static BufferedImage tankU, tankL, tankD, tankR;
    public static BufferedImage bullet_small, bullet_big;
    public static BufferedImage[] blasts = new BufferedImage[6];
    static {
        try {
            tankU = ImageIO.read(SourceMag.class.getClassLoader().getResourceAsStream("image/tank-u.png"));
            tankL = ImageIO.read(SourceMag.class.getClassLoader().getResourceAsStream("image/tank-l.png"));
            tankD = ImageIO.read(SourceMag.class.getClassLoader().getResourceAsStream("image/tank-d.png"));
            tankR = ImageIO.read(SourceMag.class.getClassLoader().getResourceAsStream("image/tank-r.png"));

            for (int i = 0; i < 6; i++) {
                blasts[i] = ImageIO.read(SourceMag.class.getClassLoader().getResourceAsStream("image/blast-"+i+".png"));
            }

            bullet_small = ImageIO.read(SourceMag.class.getClassLoader().getResourceAsStream("image/bullet-small.png"));
            bullet_big = ImageIO.read(SourceMag.class.getClassLoader().getResourceAsStream("image/bullet-big.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) throws IOException {
//        BufferedImage blast1 = ImageIO.read(SourceMag.class.getClassLoader().getResourceAsStream("image/bullet-big.png"));;
//        if (blast1!=null) {
//            System.out.println("成功");
//            return;
//        }
//        System.out.println("失败");
//    }
}
