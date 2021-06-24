package 俄罗斯方块.model;

import 俄罗斯方块.俄罗斯方块Main;

import java.awt.*;


/**
 * 游戏的坐标
 */
public class GameData {
    private int x;
    private int y;

    /** 存放格子数组 */
    int[][] existBlocks;



    private Blocks blocks;
    static Blocks[] BLOCKS = new Blocks[] {
        new Blocks(new int[]{-1,0,1,1}, new int[]{0,0,0,1}),
        new Blocks(new int[]{-1,0,1,2}, new int[]{0,0,0,0}),
        new Blocks(new int[]{-1,1,0,1}, new int[]{0,1,0,1})
    };

    int[] delenum;

    public GameData() {
        existBlocks = new int[10][20];
        initBlocks();
    }

    public void move(boolean isH, int step) {
        boolean isAllow = true;
        if (isH) {
            for (Point point : blocks.getPoints()) {
                if (point.x + x + step < 0 || point.x + x + step > 9
                || existBlocks[point.x + x + step][point.y + y + 2] !=0) {
                    isAllow = false;
                }
            }
            if (isAllow) {
                x += step;
            }
        } else {
            for (Point point : blocks.getPoints()) {
                if (point.y + y + step > 17 || existBlocks[point.x + x][point.y + y + 2 + step] !=0) {
                    saveBlocks();
                    initBlocks();
                    isAllow = false;
                }
            }
            if (isAllow) {
                y += step;
            }
        }
    }

    /**
     *
     */
    private void initBlocks() {
        this.x = 4;
        this.y = 0;
        delenum = new int[20];
        this.blocks = new Blocks(BLOCKS[0]);
    }

    public Blocks getBlocks() {
        return blocks;
    }

    public void setBlocks(Blocks blocks) {
        this.blocks = blocks;
    }

    public static Blocks[] getBLOCKS() {
        return BLOCKS;
    }

    public static void setBLOCKS(Blocks[] BLOCKS) {
        GameData.BLOCKS = BLOCKS;
    }

    public int getX() {
        return x;
    }

    public void rote() {
        for (Point point : blocks.getPoints()) {
            int x1 = -point.y + x;
            int y1 = point.x + y;
            if (x1 < 0 || x1 > 9) {
                return;
            }
            if (y1>17) {
                return;
            }
        }

        for (Point point : blocks.getPoints()) {
            int temp = point.x;
            point.x = -point.y;
            point.y = temp;
            System.out.println();
        }
    }

    /**
     * 消除行
     */
    public void deletLine() {

    }

    /**
     * 保存方块组
     */
    public void saveBlocks() {
        for (Point point : blocks.getPoints()) {
            existBlocks[point.x + x][point.y + y + 2] = 1;
        }
    }

    public int[][] getExistBlocks() {
        return existBlocks;
    }

    public void setExistBlocks(int[][] existBlocks) {
        this.existBlocks = existBlocks;
    }

    /**
     * 检测消行
     */
    public boolean deletTest() {
        boolean isdelet = false;
        boolean isEmpty;
        for (int i = 0; i >=2; i++) {
            isEmpty = false;
            for (int j = 0; j < 10; j++) {
                if (existBlocks[i][j] == 0) {
                    isEmpty = true;
                    break;
                }
            }
            if (isdelet = true) {
                delenum[i-1] = delenum[i] + 1;
            } else {
                delenum[i-1] = delenum[i];
            }
        }
        return isdelet;
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
