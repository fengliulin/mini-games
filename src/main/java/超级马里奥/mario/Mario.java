package 超级马里奥.mario;

import 超级马里奥.role.Barrier;
import 超级马里奥.role.Coin;
import 超级马里奥.util.FileRelativePath;
import 超级马里奥.view.BackgroundImage;
import 超级马里奥.view.GameJFrame;

import javax.swing.*;
import java.awt.*;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Objects;

public class Mario extends Thread {

    private GameJFrame gameJFrame;

    private boolean jumpFlag = true;

    private int x = 31;
    private int y = 358;

    private int xSpeed = 5;
    private int ySpeed = 2;

    private int width = 30;
    private int height = 32;

    private Image img;

    private boolean left = false;
    private boolean right = false;
    private boolean down = false;
    private boolean up = false;

    private final String fileRelativePath;


    //检查是否贴地
    public boolean isGravity = false;

    public Mario(GameJFrame gameJFrame) {
        fileRelativePath = FileRelativePath.getRelativePath();
        img = new ImageIcon(fileRelativePath + "mari1.png").getImage();
        this.gameJFrame = gameJFrame;
        gravity();
    }

    /**
     * 玛丽飞翔的逻辑 ；移动的逻辑都在这里。
     */
    @Override
    public void run() {
        while (true) {
            //向左走
            if (left) {
                //碰撞到了
                if (hit(Direction.Left)) {
                    this.xSpeed = 0;
                }

                if (this.x >= 0) {
                    this.x -= this.xSpeed;
                    this.img = new ImageIcon(fileRelativePath + "mari_left.gif").getImage();
                }

                this.xSpeed = 5;
            }

            //向右走
            if (right) {
                // 右边碰撞物检测应该是往右走的时候检测
                // 进行碰撞检测：至少主角（玛丽，碰撞物）
                if (hit(Direction.Right)) {
                    this.xSpeed = 0;
                }

                //人物向右移动
                if (this.x < 400) {
                    this.x += this.xSpeed;
                    this.img = new ImageIcon(fileRelativePath + "mari_right.gif").getImage();
                }

                if (this.x >= 400) {
                    //背景向左移动
                    gameJFrame.getBg().setX(gameJFrame.getBg().getX() - this.xSpeed);

                    //障碍物项左移动
                    for (int i = 0; i < gameJFrame.getBarrierList().size(); i++) {
                        Barrier barrier = gameJFrame.getBarrierList().get(i);
                        barrier.setX(barrier.getX() - this.xSpeed);
                    }

                    this.img = new ImageIcon(fileRelativePath + "mari_right.gif").getImage();
                }
                this.xSpeed = 5;
            }

            //向上跳
            if (up) {

                if (jumpFlag && !isGravity) {
                    jumpFlag = false;
                    new Thread(() -> {
                        jump();
                        jumpFlag = true;
                    }).start();
                }
            }

            try {
                this.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 向上跳
     */
    public void jump() {
        int jumpHeight = 0;
        for (int i = 0; i < 150; i++) {
            gameJFrame.getMario().setY(gameJFrame.getMario().getY() - this.ySpeed);
            jumpHeight++;

            if (hit(Direction.Up)) {
                break;
            }

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < jumpHeight; i++) {
            gameJFrame.getMario().setY(gameJFrame.getMario().getY() - this.ySpeed);
            if (hit(Direction.Up)) {
                this.ySpeed = 0;
            }
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.ySpeed = 1;//还原速度
    }

    /**
     * 重力线程
     */
    public void gravity() {
        new Thread(() -> {
            while (true) {
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                while (true) {
                    if (!jumpFlag) {
                        break;
                    }

                    if (hit(Direction.Down)) {
                        break;
                    }

                    if (y >= 358) { // 如果贴地
                        isGravity = false;
                    } else {
                        isGravity = true;
                        y += ySpeed;
                    }

                    try {
                        sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }


    /**
     * 检测碰撞
     *
     * @param
     * @return
     */
    private boolean hit(Direction direction) {
        Rectangle rectangleMario = new Rectangle(x, y, width, height);
        Rectangle rectBarrier = null;

        for (int i = 0; i < gameJFrame.getBarrierList().size(); i++) {
            Barrier barrier = gameJFrame.getBarrierList().get(i);
            switch (direction) {
                case Left:
                    rectBarrier = new Rectangle(barrier.getX() + 2, barrier.getY(), barrier.getWidth(), barrier.getHeight());
                    break;
                case Right:
                    rectBarrier = new Rectangle(barrier.getX() - 2, barrier.getY(), barrier.getWidth(), barrier.getHeight());
                    break;
                case Up:
                    rectBarrier = new Rectangle(barrier.getX(), barrier.getY() + 1, barrier.getWidth(), barrier.getHeight());
                    break;
                case Down:
                    rectBarrier = new Rectangle(barrier.getX(), barrier.getY() - 2, barrier.getWidth(), barrier.getHeight());
                    break;
            }
            // 两个矩形相交就碰撞了
            if (rectangleMario.intersects(rectBarrier) && direction.equals(Direction.Up)) {
                if (Coin.class.isAssignableFrom(barrier.getClass())) { // 是金币砖块
                    // 金币修改
                    barrier.setImg(new ImageIcon(fileRelativePath + "coin_brick_null.png").getImage());
                }
                return true; // 不让马里奥穿过
            } else if (rectangleMario.intersects(rectBarrier)) {
                return true;
            }

        }

        return false;
    }


    public GameJFrame getGameJFrame() {
        return gameJFrame;
    }

    public void setGameJFrame(GameJFrame gameJFrame) {
        this.gameJFrame = gameJFrame;
    }

    public boolean isJumpFlag() {
        return jumpFlag;
    }

    public void setJumpFlag(boolean jumpFlag) {
        this.jumpFlag = jumpFlag;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public int getySpeed() {
        return ySpeed;
    }

    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isGravity() {
        return isGravity;
    }

    public void setGravity(boolean gravity) {
        isGravity = gravity;
    }


}
