package by.it.han.jd01_15;

import java.io.File;

public class PatchFinder {
    private static final String USER_DIR = "user.dir";
    private static final String SRC = "src";
    private static final char OLD_SEPARATOR = '.';

    private PatchFinder() {
    }


    public static String getFilePath(String fileName, Class<?> clazz) {
        String projectRoot = System.getProperty(USER_DIR);
        String name = clazz.getName();
        String path = name.replace(clazz.getSimpleName(), "")
                .replace(OLD_SEPARATOR, File.separatorChar);
        path = projectRoot + File.separatorChar + SRC + File.separatorChar + path;
        return path + fileName;
    }

}
