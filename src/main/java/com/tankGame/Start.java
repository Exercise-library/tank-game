package com.tankGame;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 坦克大战游戏入口
 */
public class Start {

    public static void main(String[] args) {

        JFrame jFrame = new JFrame();
        jFrame.setSize(500,500);
        jFrame.setVisible(true);
        jFrame.setTitle("Tank game");
        jFrame.setResizable(false);

        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }

}
