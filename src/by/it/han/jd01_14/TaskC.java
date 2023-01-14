package by.it.han.jd01_14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class TaskC {

    private static final String RESULT_FILE_NAME = "resultTaskC.txt";
    private static final String _DIR = "dir:";
    public static final String _FILE = "-file:";
    private static boolean isAddToFile = false;

    public static void main(String[] args) {
        String path = getPath();
        File file = new File(path);
        printFilesToConsole(file);
        writeToResultFile(file);
    }

    private static void writeToResultFile(File file) {
        String filePath = TaskA.getFilePath(RESULT_FILE_NAME);
        try (PrintStream out = new PrintStream(new FileOutputStream(filePath, isAddToFile))) {
            isAddToFile = true;
            if (file.isFile()) {
                out.println(_FILE + file.getName());
            } else {
                out.println(_DIR + file.getName());
                for (File f : file.listFiles()) {
                    writeToResultFile(f);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printFilesToConsole(File file) {
        if (file.isFile()) {
            System.out.println(_FILE + file.getName());
        } else {
            System.out.println(_DIR + file.getName());
            for (File f : file.listFiles()) {
                printFilesToConsole(f);
            }
        }
    }

    private static String getPath() {
        String property = System.getProperty("user.dir");
        return property + File.separatorChar + "src"
                + File.separatorChar + "by"
                + File.separatorChar + "it"
                + File.separatorChar + "han"
                + File.separatorChar;
    }
}
