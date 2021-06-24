package 俄罗斯方块.controller;

import 俄罗斯方块.model.GameData;
import 俄罗斯方块.view.ImgButton;
import 俄罗斯方块.view.StaticPanel;
import 俄罗斯方块.俄罗斯方块Main;

import javax.swing.*;
import java.util.Objects;

public class Opration {
    private 俄罗斯方块Main mainWin;
    private GameData gameData;

    public ImgButton left;
    public ImgButton right;
    public ImgButton down;
    public ImgButton rotate;
    public JButton start;
    public ImgButton set;
    public  ImgButton login;

    public Opration() {
        ImageIcon leftIcon = new ImageIcon(Objects.requireNonNull(StaticPanel.class.getClassLoader().getResource("images/left.png")));
        ImageIcon rightIcon = new ImageIcon(Objects.requireNonNull(StaticPanel.class.getClassLoader().getResource("images/right.png")));
        ImageIcon downIcon = new ImageIcon(Objects.requireNonNull(StaticPanel.class.getClassLoader().getResource("images/down.png")));
        ImageIcon rotateIcon = new ImageIcon(Objects.requireNonNull(StaticPanel.class.getClassLoader().getResource("images/rotate.png")));
        ImageIcon setIcon = new ImageIcon(Objects.requireNonNull(StaticPanel.class.getClassLoader().getResource("images/setting.png")));
        ImageIcon loginIcon = new ImageIcon(Objects.requireNonNull(StaticPanel.class.getClassLoader().getResource("images/signin.png")));

        left = new ImgButton(leftIcon) {
            @Override
            public void onClick() {
                gameData.move(true, -1);
                mainWin.getGamePanel().repaint();
            }
        };
        right = new ImgButton(rightIcon) {
            @Override
            public void onClick() {
                gameData.move(true, 1);
                mainWin.getGamePanel().repaint();
            }
        };
        down = new ImgButton(downIcon) {
            @Override
            public void onClick() {
                gameData.move(false, 1);
                mainWin.getGamePanel().repaint();
            }
        };
        rotate = new ImgButton(rotateIcon) {
            @Override
            public void onClick() {
                gameData.rote();
                mainWin.getGamePanel().repaint();
            }
        };
        start = new JButton("开始");

        set = new ImgButton(setIcon) {
            @Override
            public void onClick() {

            }
        };
        login = new ImgButton(loginIcon) {
            @Override
            public void onClick() {

            }
        };

    }

    /**
     * 关联视图
     *
     * @param 俄罗斯方块Main
     */
    public void setWin(俄罗斯方块Main 俄罗斯方块Main) {
        this.mainWin = 俄罗斯方块Main;
    }

    /**
     * 关联数据
     *
     * @param gameData
     */
    public void setData(GameData gameData) {
        this.gameData = gameData;
    }


}
