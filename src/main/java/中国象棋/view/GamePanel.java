package 中国象棋.view;

import 中国象棋.util.FileRelativePath;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private final String path =  FileRelativePath.getRelativePath();

    private final String bgPath = path + "棋盘.jpg";

    @Override
    public void paint(Graphics g) {
//        super.paint(g);
//
        g.drawImage(Toolkit.getDefaultToolkit().getImage(bgPath), 0, 0, this);
        /*g.drawImage(Toolkit.getDefaultToolkit().getImage(redChe), 5, 5, 30, 30, this);
        g.drawImage(Toolkit.getDefaultToolkit().getImage(redMa), 45, 5, 30, 30, this);
        g.drawImage(Toolkit.getDefaultToolkit().getImage(redXiang), 85, 5, 30, 30, this);*/

        String[] names = {
                "红-车",
                "红-马",
                "红-相",
                "红-士"
        };

        for (int i = 0; i < names.length; i++) {
            String path = this.path + names[i] + ".png";
            g.drawImage(Toolkit.getDefaultToolkit().getImage(path), 5 + i * 40, 5, 30,30, this);
        }
    }

}
