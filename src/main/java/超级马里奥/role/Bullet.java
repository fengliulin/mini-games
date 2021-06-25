package 超级马里奥.role;

/**
 * 子弹
 */
public class Bullet {

    private int x, y;
    private int width;
    private int speed = 1;

    public Bullet(int x, int y, int width) {
        super();
        this.x = x;
        this.y = y;
        this.width = width;
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

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
