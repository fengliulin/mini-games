package 俄罗斯方块.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class ImgButton extends JButton {
    public ImgButton(ImageIcon imageIcon) {
        super.setContentAreaFilled(false);
        super.setIcon(imageIcon);
        super.setBorder(null);

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onClick();
            }
        });
    }

    public abstract void onClick();
}
