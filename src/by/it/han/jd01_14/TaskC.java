package by.it.han.jd01_14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class TaskC {

    private static final String RESULT_FILE_NAME = "resultTaskC.txt";

    public static void main(String[] args) {
        String path = getPath();
        File dir = new File(path);
        File[] files = dir.listFiles();
        printFilesToConsole(files);
        writeToResultFile(files);
    }

    private static void writeToResultFile(File[] files) {
        String filePath = TaskA.getFilePath(RESULT_FILE_NAME);
        try (PrintStream out = new PrintStream(filePath)) {
            for (File file : files) {
                out.println("dir:" + file.getName());
                for (File listFile : file.listFiles()) {
                    out.println("-file:" + listFile.getName());
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printFilesToConsole(File[] files) {
        for (File file : files) {
            System.out.println("dir:" + file.getName());
            for (File listFile : file.listFiles()) {
                System.out.println("-file:" + listFile.getName());
            }
        }
    }

    private static String getPath() {
        String property = System.getProperty("user.dir");
        String path = property + File.separatorChar + "src"
                + File.separatorChar + "by"
                + File.separatorChar + "it"
                + File.separatorChar + "han"
                + File.separatorChar;
        return path;
    }
}
