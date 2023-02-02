package by.it.bolshakov.jd02_06;

import java.io.File;

public class PathFinder {

    private PathFinder() {
    }

    private static final String USER_DIR = "user.dir";
    private static final String SRC = "src";

    public static String getFilePath(String filename, Class<?> classFolder) {
        String projectRoot = System.getProperty(USER_DIR);
        String name = classFolder.getName();
        String path = name
                .replace(classFolder.getSimpleName(), "")
                .replace(".", File.separator);
        path = projectRoot + File.separator + SRC + File.separator + path;
        return path + filename;
    }
}
