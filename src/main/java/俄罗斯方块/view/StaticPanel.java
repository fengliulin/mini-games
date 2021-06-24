package 俄罗斯方块.view;

import 俄罗斯方块.controller.Opration;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

/**
 * 面板就是画布
 */
public class StaticPanel extends JPanel {
    JButton left;
    JButton right;
    JButton down;
    JButton rotate;
    JButton start;
    JButton set;
    JButton login;


    public StaticPanel(Opration opration) {

        this.left = opration.left;
        this.right = opration.right;
        this.down = opration.down;
        this.rotate = opration.rotate;
        this.start = opration.start;
        this.set = opration.set;
        this.login = opration.login;

        setBounds(0, 0, 360, 600);
        super.setOpaque(false);
        super.setLayout(null);


        left.setBounds(233, 255, 45, 45);
        right.setBounds(278, 255, 45, 45);
        down.setBounds(233, 300, 45, 45);
        rotate.setBounds(278, 300, 45, 45);
        start.setBounds(233, 350, 90, 50);
        set.setBounds(240, 510, 48, 48);
        login.setBounds(290, 510, 48, 48);
        super.add(left);
        super.add(right);
        super.add(down);
        super.add(rotate);
        super.add(start);
        super.add(set);
        super.add(login);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(0, 0, 0, 30));
        // 主屏
        g.fillRect(15, 30, 200, 360);
        // 排名区
        g.fillRect(15, 405, 200, 130);
        // 右侧排版
        g.fillRect(233, 20, 110, 400);
        g.setColor(new Color(2, 2, 2, 30));
        // 得分区
        g.fillRect(233, 30, 90, 70);
        // 提示区
        g.fillRect(233, 105, 90, 140);
        // 操作区
        g.fillRect(233, 255, 90, 90);
        // 边框
        g.setColor(Color.white);
        ((Graphics2D) g).setStroke(new BasicStroke(3L));
        g.drawRect(13, 28, 204, 364);
        g.drawRect(13, 403, 204, 134);
        g.setFont(new Font("黑体", Font.PLAIN, 20));
        g.setColor(Color.DARK_GRAY);
        g.drawString("得分", 240, 53);
        g.drawString("下一个", 236, 140);
        g.drawString("荣誉榜", 25, 435);
    }
}
