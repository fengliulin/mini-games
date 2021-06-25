package 超级马里奥.util;

import 超级马里奥.view.GameJFrame;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Objects;

/**
 * 获取相对路径
 */
public class FileRelativePath {

    public static String getRelativePath() {
        try {
            String filePath =
                    Objects.requireNonNull(FileRelativePath.class.getClassLoader().getResource("超级马里奥/map.txt"))
                            .getPath();

            String replace1 = filePath.replace("%e5%b0%8f%e6%b8%b8%e6%88%8f%e5%ad%a6%e4%b9%a0", URLDecoder.decode("%e5%b0%8f%e6%b8%b8%e6%88%8f%e5%ad%a6%e4%b9%a0", "UTF-8"));
            String replace2 = replace1.replace("%e8%b6%85%e7%ba%a7%e9%a9%ac%e9%87%8c%e5%a5%a5", URLDecoder.decode("%e8%b6%85%e7%ba%a7%e9%a9%ac%e9%87%8c%e5%a5%a5", "UTF-8"));
            int i = replace2.lastIndexOf("/");
            return replace2.substring(0, i) + "/";
        } catch (
                UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
