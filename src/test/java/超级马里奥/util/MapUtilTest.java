package 超级马里奥.util;

import junit.framework.TestCase;
import org.junit.Test;

public class MapUtilTest {

    @Test
    public void testReadMap() {
        MapUtil mapUtil = new MapUtil();
        int[][] ints = mapUtil.readMap();
        for (int i = 0; i < ints.length; i++) {
            int[] column = ints[i]; // 取出一行，得到所有的列
            for (int j = 0; j < column.length; j++) {
                System.out.print(column[j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }
}