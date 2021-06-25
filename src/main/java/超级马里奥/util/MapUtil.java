package 超级马里奥.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MapUtil {

    private List<String> list = new ArrayList<>();

    private int[][] map = null;


    public int[][] readMap() {
        //region 把读取的文件每一行放入list数组里
        InputStream resourceAsStream = MapUtil.class.getClassLoader().getResourceAsStream("超级马里奥/map.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(Objects.requireNonNull(resourceAsStream));
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        try {
            String value = bufferedReader.readLine();

            while (value != null) {
                list.add(value);
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                inputStreamReader.close();
                resourceAsStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //endregion

        //region 拆分，文件的内容给数组
        int row = list.size();
        int column = 0;

        for (String s : list) {
            String[] values = s.split(",");
            column = values.length;
        }

        map = new int[row][column];

        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            String[] values = s.split(",");
            for (int j = 0; j < values.length; j++) {
                map[i][j] =  Integer.parseInt(values[j]);
            }
        }
        //endregion
        System.out.println();
        return map;
    }
}
