package 中国象棋.util;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.util.Objects;

/**
 * 获取相对路径
 */
public class FileRelativePath {

    public static String getRelativePath() {
        try {
            URI filePath =
                    FileRelativePath.class.getClassLoader().getResource("").toURI();
            return filePath.getPath() + "中国象棋/";
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }


        return null;
    }
}
