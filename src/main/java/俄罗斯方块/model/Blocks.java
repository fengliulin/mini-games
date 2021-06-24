package 俄罗斯方块.model;

import java.awt.*;

/**
 * 画方块
 */
public class Blocks {
    Point[] points;

    public Point[] getPoints() {
        return points;
    }

    public void setPoints(Point[] points) {
        this.points = points;
    }

    public Blocks(int[] x, int[] y) {
        points = new Point[4];
        for (int i = 0; i < 4; i++) {
            points[i] = new Point(x[i], y[i]);
        }
        System.out.println();
    }

    public Blocks(Blocks blocks) {
        points = new Point[4];
        for (int i = 0; i < 4; i++) {
            points[i] = new Point(blocks.points[i].x, blocks.points[i].y);
        }
        System.out.println();
    }
}
