package 超级马里奥;

import 超级马里奥.event.KeyListener;
import 超级马里奥.view.GameJFrame;



public class MainRun {
    public static void main(String[] args) {

        GameJFrame gameJFrame = new GameJFrame();
        gameJFrame.setVisible(true);

        // 添加键盘事件监听
        KeyListener keyListener = new KeyListener(gameJFrame);
        gameJFrame.addKeyListener(keyListener);
    }
}
