package 中国象棋.util;

import junit.framework.TestCase;
import org.junit.Test;

public class FileRelativePathTest{

    @Test
    public void testGetRelativePath() {

        String relativePath = FileRelativePath.getRelativePath();
        System.out.println(relativePath);
    }
}