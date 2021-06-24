package 贪吃蛇;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

public class 贪吃蛇Main extends JFrame {

    private Snake snake;

    private Timer timer; // 计时器

    private JPanel jPanel;

    private Node food; // 食物

    public 贪吃蛇Main() {
        initFood(); // 初始化食物
        initFrame(); // 初始化窗体参数
        initGamePanel(); // 初始化游戏棋盘
        initSnake(); // 初始化蛇
        initTimer(); // 初始化定时器
        setKeyListener(); // 设置键盘监听，让蛇随着上下左右方向移动

    }

    private void initFood() {
        food = new Node();
        food.random();
    }

    private void setKeyListener() {
        super.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        if (snake.getDirection() != Direction.DOWN)
                            snake.setDirection(Direction.UP);
                        break;
                    case KeyEvent.VK_DOWN:
                        if (snake.getDirection() != Direction.UP)
                        snake.setDirection(Direction.DOWN);
                        break;
                    case KeyEvent.VK_LEFT:
                        if (snake.getDirection() != Direction.RIGHT)
                            snake.setDirection(Direction.LEFT);
                        break;
                    case KeyEvent.VK_RIGHT:
                        if (snake.getDirection() != Direction.LEFT)
                            snake.setDirection(Direction.RIGHT);
                        break;
                }
                System.out.println(e.getKeyCode());
            }
        });
    }

    private void initTimer() {
        TimerTask timerTask = new TimerTask(){
            @Override
            public void run() {
                snake.move();
                Node head = snake.getBody().getFirst();
                // 判断蛇头是否和食物重合
                if (head.getX() == food.getX() && head.getY() == food.getY()) {
                    snake.eat(food);
                    food.random();
                }

                // 重绘游戏棋盘
                jPanel.repaint();
            }
        };
        timer = new Timer();
        timer.scheduleAtFixedRate(timerTask, 0, 150); // 计时器，每100毫秒执行一次
    }

    private void initSnake() {
        snake = new Snake();
    }

    private void initGamePanel() {
        jPanel = new JPanel(){
            @Override
            public void paint(Graphics g) { // 绘制游戏棋盘中的内容,Graphics可以看作是一个画笔，可以绘制图形

                g.clearRect(0,0, 620, 640);

                // 绘制40条横线
                for (int n = 0; n <= 40; n++) {
                    g.drawLine(0, n * 15, 600, n * 15);
                }
                // 绘制40条竖线 第n条就是n*15
                for (int n = 0; n <= 40; n++) {
                    g.drawLine(n * 15, 0, n * 15, 600);
                }

                // 绘制蛇
                LinkedList<Node> body = snake.getBody();
                for (Node node : body) {
                    // 一个格子是15，所以乘以15
                    g.fillRect(node.getX() * 15, node.getY() * 15, 15, 15);
                }

                // 绘制食物
                g.fillRect(food.getX() * 15, food.getY() * 15, 15, 15);
            }
        };
        // 把棋盘JPanel面板添加到窗体中
        super.add(jPanel);
    }

    private void initFrame() {
        super.setTitle("贪吃蛇");
        super.setSize(620, 640); // 设置窗体大小
        super.setLocation(400, 400); // 设置窗体位置
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置窗体关闭
        super.setResizable(false); // 设置窗体大小不可变
    }

    public static void main(String[] args) {
        new 贪吃蛇Main().setVisible(true);
    }
}
