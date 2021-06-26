package 中国象棋;

import 中国象棋.view.GamePanel;

import javax.swing.*;
import java.awt.*;

/**
 * JFrame自带一个面板，但是这个面板有bug，最好在重新添加一个JPanel
 */
public class MainFrame extends JFrame {

    private JPanel gamePanel = new GamePanel();

    public MainFrame() {
        super.setSize(400, 500);
        super.setLocationRelativeTo(null); // 居中
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLayout(null);
        gamePanel.setBounds(0,0,400,500);
        super.add(gamePanel);
    }

    public static void main(String[] args) {
        MainFrame jFrame = new MainFrame();

        jFrame.setVisible(true); // 显示窗体

    }
}
