package by.it.vasileuskaya.calc.util;

import by.it.vasileuskaya.calc.ConsoleRunner;

import java.io.File;

public class PathFinder {
    private PathFinder() {
    }

    private static final String USER_DIR = "user.dir";
    private static final String SRC = "src";

    public static String getFilePath(String filename, Class<ConsoleRunner> consoleRunnerClass) {
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
