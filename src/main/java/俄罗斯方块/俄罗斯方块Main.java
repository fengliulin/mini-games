package 俄罗斯方块;

import 俄罗斯方块.controller.Opration;
import 俄罗斯方块.model.GameData;
import 俄罗斯方块.view.GamePanel;
import 俄罗斯方块.view.StaticPanel;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class 俄罗斯方块Main extends JFrame {

    private GamePanel gamePanel;
    private Container mainPane;

    private Opration opration = new Opration();
    private GameData gameData = new GameData();

    public 俄罗斯方块Main() throws HeadlessException {

        this.mainPane = super.getLayeredPane();
        initJFrame();
    }

    private void initJFrame() {
        opration.setWin(this);
        opration.setData(gameData);
        super.setTitle("俄罗斯方块");
        super.setResizable(false);
        super.setLayout(null);
        super.setBounds(500, 200, 360, 600);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground();
        // 绘制区域
        mainPane.add(new StaticPanel(opration));

        // 添加游戏方块
        setGamePanel();

        new AUtoDown(gameData, this).start();

    }

    private void setGamePanel() {
        gamePanel = new GamePanel(gameData);
        mainPane.add(gamePanel);
    }

    /**
     * 设置背景
     */
    public void setBackground() {
        URL resource = 俄罗斯方块Main.class.getClassLoader().getResource("images/back3.png");
        ImageIcon imageIcon = new ImageIcon(resource);
        JLabel jLabel = new JLabel(imageIcon);
        jLabel.setBounds(0,0,360,600);
        super.getContentPane().add(jLabel);
    }

    // 获取游戏区
    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public static void main(String[] args) {


        new 俄罗斯方块Main().setVisible(true);
    }
}

class  AUtoDown extends Thread {
    private GameData gameData;
    private 俄罗斯方块Main 俄罗斯方块Main;

    public AUtoDown(GameData gameData, 俄罗斯方块Main 俄罗斯方块Main) {
        this.gameData = gameData;
        this.俄罗斯方块Main = 俄罗斯方块Main;
    }

    @Override
    public void run() {
        while (true) {
            gameData.move(false, 1);
            try {
                sleep(1000);
                俄罗斯方块Main.getGamePanel().repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
