package 超级马里奥.view;

import javax.swing.*;
import java.awt.*;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Objects;

public class BackgroundImage {

    private int x = 0;
    private int y = 0;

    private int ox = 0;
    private int oy = 0;

    private Image img;


    public BackgroundImage() {
        String path = Objects.requireNonNull(BackgroundImage.class.getResource("/超级马里奥/startBack.jpg")).getPath();
        String replacePath = null;
        try {
            String replace1 = path.replace("%e5%b0%8f%e6%b8%b8%e6%88%8f%e5%ad%a6%e4%b9%a0", URLDecoder.decode("%e5%b0%8f%e6%b8%b8%e6%88%8f%e5%ad%a6%e4%b9%a0", "UTF-8"));
            String replace2 = replace1.replace("%e8%b6%85%e7%ba%a7%e9%a9%ac%e9%87%8c%e5%a5%a5", URLDecoder.decode("%e8%b6%85%e7%ba%a7%e9%a9%ac%e9%87%8c%e5%a5%a5", "UTF-8"));
            replacePath  = replace2;
            System.out.println();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        this.img = new ImageIcon(replacePath).getImage();;
        System.out.println();
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

    public int getOx() {
        return ox;
    }

    public void setOx(int ox) {
        this.ox = ox;
    }

    public int getOy() {
        return oy;
    }

    public void setOy(int oy) {
        this.oy = oy;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }
}