package 超级马里奥.view;

import 超级马里奥.mario.Mario;
import 超级马里奥.role.*;
import 超级马里奥.util.FileRelativePath;
import 超级马里奥.util.MapUtil;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class GameJFrame extends JFrame {

    private final String filePath = FileRelativePath.getRelativePath();

    private Mario mario;


    private Barrier brick;
    private Barrier coin;
    private Barrier pipe;

    private BackgroundImage bg;

    /**
     * 障碍物列表
     */
    private final ArrayList<Barrier> barrierList = new ArrayList<>();

    /**
     * 子弹列表
     */
    private final ArrayList<Bullet> bulletList = new ArrayList<>();

    /**
     * 子弹速度
     */
    private int bulletSpeed = 0;

    private final int[][] map = new MapUtil().readMap();

    public GameJFrame() throws HeadlessException {
        initJFrame();

        initViewImages(); // 初始化马里奥，背景，地图，金币，钻头，水管
    }


    private void initViewImages() {
        mario = new Mario(this);

        bg = new BackgroundImage();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 1) { // 砖头
                    Brick brick = new Brick(j * 30, i * 30, 30, 30, new ImageIcon(filePath + "brick.png").getImage());
                    barrierList.add(brick);
                }

                if (map[i][j] == 2) { // 金币
                    Coin coin = new Coin(j * 30, i * 30, 30, 30, new ImageIcon(filePath + "coin_brick.png").getImage());
                    barrierList.add(coin);
                }

                if (map[i][j] == 3) { // 水管
                    Pipe pipe = new Pipe(j * 30, i * 30 + 5, 60, 120, new ImageIcon(filePath + "pipe.png").getImage());
                    barrierList.add(pipe);
                }
            }
        }
        System.out.println();

        mario.start(); // 开启线程

        new Thread(() -> { // 开启一个线程重绘窗体
            while (true) {
                repaint();
            }
        }).start();

        // 背景音乐
		new Thread(new Runnable() {
			@Override
			public void run() {
                Clip clip = null;
                try {
                    clip = AudioSystem.getClip();
                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(GameJFrame.class.getClassLoader().getResourceAsStream("超级马里奥/music/bg1.wav"));
                    clip.open(audioInputStream);
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                    e.printStackTrace();
                }
                
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
		}).start();
    }

    @Override
    public void paint(Graphics g) {
        // 双缓冲解决闪烁
        Image image = super.createImage(this.getSize().width, this.getSize().height);


        // 画背景
        g.drawImage(bg.getImg(), bg.getX(), bg.getY(), this);

        // 画障碍物
        for (Barrier barrier : barrierList) {
            g.drawImage(barrier.getImg(), barrier.getX(), barrier.getY(), barrier.getWidth(), barrier.getHeight(), this);
        }

        // 画子弹
        for (Bullet bullet : bulletList) {
            Color c = g.getColor();
            g.setColor(Color.red);
            g.fillOval(bullet.getX() + bullet.getSpeed(), bullet.getY(), bullet.getWidth(), bullet.getWidth());
        }


        // 画马里奥
        g.drawImage(mario.getImg(), mario.getX(), mario.getY(), mario.getWidth(), mario.getHeight(), this);
    }

    private void initJFrame() {
        super.setSize(800, 450);
        super.setTitle("超级玛丽");
        super.setResizable(false);
        super.setLocationRelativeTo(null); // 放到屏幕中间
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    public String getFilePath() {
        return filePath;
    }

    public Mario getMario() {
        return mario;
    }

    public Barrier getBrick() {
        return brick;
    }

    public Barrier getCoin() {
        return coin;
    }

    public Barrier getPipe() {
        return pipe;
    }

    public BackgroundImage getBg() {
        return bg;
    }

    public ArrayList<Barrier> getBarrierList() {
        return barrierList;
    }

    public ArrayList<Bullet> getBulletList() {
        return bulletList;
    }

    public int getBulletSpeed() {
        return bulletSpeed;
    }

    public int[][] getMap() {
        return map;
    }
}
