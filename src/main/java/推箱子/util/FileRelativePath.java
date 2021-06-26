package 推箱子.util;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * 获取相对路径
 */
public class FileRelativePath {

    public static String getRelativePath() {
        try {
            URI filePath =
                    FileRelativePath.class.getClassLoader().getResource("").toURI();
            return filePath.getPath() + "推箱子/";
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }


        return null;
    }
}
