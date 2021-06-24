package 贪吃蛇;

import java.util.LinkedList;
import java.util.List;

/**
 * 贪吃蛇
 * 出生的时候3个节点
 */
public class Snake {
    private LinkedList<Node> body; // 蛇身体

    // 蛇的运动方向
    private Direction direction = Direction.LEFT;

    // 蛇是否活着
    private boolean isLiving = true;

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Snake() {
        // 初始化蛇身体
        initSnake();
    }

    private void initSnake() {
        body = new LinkedList<>(); // 原有保持不动，头添加一个，删除尾部的一个
        body.add(new Node(16, 20));
        body.add(new Node(17, 20));
        body.add(new Node(18, 20));
        body.add(new Node(19, 20));
        body.add(new Node(20, 20));
        body.add(new Node(21, 20));
        body.add(new Node(22, 20));
    }

    // 蛇会沿着蛇头方向移动 头添加一个，删除尾部的一个
    public void move() {
        if (isLiving) {
            Node head = body.getFirst();
            switch (direction) {
                case UP:
                    body.addFirst(new Node(head.getX(), head.getY() - 1));
                    break;
                case DOWN:
                    body.addFirst(new Node(head.getX(), head.getY() + 1));
                    break;
                case LEFT:
                    body.addFirst(new Node(head.getX() - 1, head.getY()));
                    break;
                case RIGHT:
                    body.addFirst(new Node(head.getX() + 1, head.getY()));
                    break;
            }

            // 删除最后的节点
            body.removeLast();
        }

        // 判断蛇是否撞墙
        Node head = body.getFirst();
        if (head.getX() < 0 || head.getY() < 0 || head.getX() >= 40 || head.getY() >= 40) {
            isLiving = false;
        }

        // 判断蛇是否碰到自己的身体
        for (int i = 1; i < body.size(); i++) {
            Node node = body.get(i); // 除去头开始判断
            if (head.getX() == node.getX() && head.getY() == node.getY()) {
                isLiving = false;
                break;
            }
        }
    }

    public LinkedList<Node> getBody() {
        return body;
    }

    public void setBody(LinkedList<Node> body) {
        this.body = body;
    }

    // 吃食物:沿着蛇头的移动方向添加一个节点
    public void eat(Node food) {
        Node head = body.getFirst();
        switch (direction) {
            case UP:
                body.addFirst(new Node(head.getX(), head.getY() - 1));
                break;
            case DOWN:
                body.addFirst(new Node(head.getX(), head.getY() + 1));
                break;
            case LEFT:
                body.addFirst(new Node(head.getX() - 1, head.getY()));
                break;
            case RIGHT:
                body.addFirst(new Node(head.getX() + 1, head.getY()));
                break;
        }
    }
}
