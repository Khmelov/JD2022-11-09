package by.it.vasileuskaya.jd01_15;

import java.io.File;

public class PathFinder {
    private PathFinder() {
    }

    private static final String USER_DIR = "user.dir";
    private static final String SRC = "src";

    public static String getFilePath(String filename) {
        String projectRoot = System.getProperty(
                USER_DIR);
        Class<?> currentClass = PathFinder.class;
        String name = currentClass.getName();
        String path = name.replace(currentClass.getSimpleName(), "")
                .replace(".", File.separator);
        path = projectRoot + File.separator + SRC + File.separator + path;
        return path + filename;
    }
}
