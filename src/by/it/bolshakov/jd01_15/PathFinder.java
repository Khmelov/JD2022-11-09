package by.it.bolshakov.jd01_15;

import by.it.bolshakov.jd01_14.TaskA;

import java.io.File;

public class PathFinder {

    private PathFinder() {
    }

    public static final String USER_DIR = "user.dir";
    public static final String SRC = "src";

    public static String getFilePath(String filename, Class<?> classFolder) {
        String projectRoot = System.getProperty(USER_DIR);
        classFolder = PathFinder.class;
        String path = classFolder.getName();
        path = path.replace(classFolder.getSimpleName(), "")
                .replace(".", File.separator);
        path = projectRoot + File.separator + SRC + File.separator + path;
        return path + filename;
    }
}
