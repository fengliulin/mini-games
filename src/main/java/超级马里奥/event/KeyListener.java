package 超级马里奥.event;

import 超级马里奥.role.Bullet;
import 超级马里奥.util.FileRelativePath;
import 超级马里奥.view.GameJFrame;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {
    private GameJFrame gameFrame;

    private final String fileRelativePath = FileRelativePath.getRelativePath();;

    public KeyListener(GameJFrame gameFrame) {
        this.gameFrame = gameFrame;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                gameFrame.getMario().setRight(true);
                break;
            case KeyEvent.VK_LEFT:
                gameFrame.getMario().setLeft(true);
                break;
            case KeyEvent.VK_B:
                addBullet(); // 添加子弹
                break;
            case KeyEvent.VK_UP:
                gameFrame.getMario().setUp(true);
                break;
        }
    }

    private void addBullet() {
        Bullet b = new Bullet(gameFrame.getMario().getX(),gameFrame.getMario().getY(),10);
        if(gameFrame.getMario().isLeft()) {
            b.setSpeed(-2);
        }
        if(gameFrame.getMario().isRight()) {
            b.setSpeed(2);
        }
        gameFrame.getBulletList().add(b);
    }

    @Override
    public void keyReleased(KeyEvent e) {
       switch (e.getKeyCode()) {
           case KeyEvent.VK_RIGHT:
               gameFrame.getMario().setRight(false);
               gameFrame.getMario().setImg(new ImageIcon(fileRelativePath + "mari1.png").getImage());
               break;
           case KeyEvent.VK_LEFT:
               gameFrame.getMario().setLeft(false);
               gameFrame.getMario().setImg(new ImageIcon(fileRelativePath + "mari_left1.png").getImage());
               break;
           case KeyEvent.VK_UP:
               gameFrame.getMario().setUp(false);
               break;
       }
    }
}
