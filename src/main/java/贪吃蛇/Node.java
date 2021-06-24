package 贪吃蛇;

import java.util.Random;

/**
 * 节点类： 每一条蛇是由若干个节点组成的，每一个节点有横纵坐标来确定位置
 */
public class Node {
    private int x;
    private int y;

    // 随机生成位置的方法
    public void random() {
        Random random = new Random();
        // 生成横坐标
        x = random.nextInt(40);
        y = random.nextInt(40);
    }

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Node() {
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
}
