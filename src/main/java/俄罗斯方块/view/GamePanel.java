package 俄罗斯方块.view;

import 俄罗斯方块.model.GameData;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private GameData gameData;

    public GamePanel(GameData gameData) {
        this.gameData = gameData;
        super.setOpaque(false); // 这样设置不要背景
        super.setBounds(15, 30, 200, 360);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Point point : gameData.getBlocks().getPoints()) {
            g.fillRect((point.x + gameData.getX()) * 20,
                    (point.y + gameData.getY()) * 20, 20, 20);
        }
        System.out.println();
        for (int i = 19; i >=0; i--) {
            for (int j = 0; j < 10; j++) {
                if (gameData.getExistBlocks()[j][i] != 0) {
                    g.fillRect((j)*20, (i-2)*20, 20, 20);
                }
            }
        }
    }
}
