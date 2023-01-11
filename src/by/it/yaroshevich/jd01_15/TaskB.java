package by.it.yaroshevich.jd01_15;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TaskB {

    //jklnlnln
    //jljlllm
    public static final String FILENAME = "TaskB.txt";

    public static void main(String[] args) {
        String filePath = PathFinder.getFilePath(FILENAME, TaskB.class);

        saveToFile(filePath);
        showToConsole(filePath);
    }
        public static void showToConsole(String filePath){
            try {
                List<String> lines = Files.readAllLines(Path.of(filePath));
                for (String line : lines) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }

    public static void saveToFile (String filePath){
        try {
            PrintWriter printWriter = new PrintWriter(filePath);
            printWriter.println(filePath);
            printWriter.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}


