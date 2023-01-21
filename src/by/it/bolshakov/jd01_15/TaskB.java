package by.it.bolshakov.jd01_15;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Класс считывает текст самого себя
 * И удаляет любые виды комментариев
 * Кроме тех, что внутри строки
 *
 */
public class TaskB {

    public static final String OUTPUT_FILE = "TaskB.txt";
    public static final String INPUT_FILE = "TaskB.java";
    public static final Class<TaskB> CLASS_INSTANCE = TaskB.class;
    public static final String MULTILINE_COMMENT_START = "/*";
    public static final String MULTILINE_COMMENT_END = "*/";
    public static final String SINGLE_COMMENT_START = "//";

    public static void main(String[] args) {
        /* Многострочный
        комментарий 1*/
         /* Многострочный
        комментарий 2*/
        //Однострочный комментарий 1
        //Однострочный комментарий 2
        String filepath = PathFinder.getFilePath(INPUT_FILE, CLASS_INSTANCE);
        try {
            StringBuilder text = stripCommentsFromFile(filepath);
            System.out.println(text);
            saveStringToFile(text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void saveStringToFile(StringBuilder text) throws IOException {
        String outputFile = PathFinder.getFilePath(OUTPUT_FILE, CLASS_INSTANCE);
        try (FileWriter txtOutput = new FileWriter(outputFile)) {
            txtOutput.write(text.toString());
        }
    }

    private static StringBuilder stripCommentsFromFile(String filepath) throws IOException {
        StringBuilder text = new StringBuilder(Files.readString(Path.of(filepath)));
        try {
            while (true) text.replace(text.indexOf(MULTILINE_COMMENT_START), text.indexOf(MULTILINE_COMMENT_END) + 2, "");
        } catch (StringIndexOutOfBoundsException e) {

        }
        try {
            while (true) text.replace(text.indexOf(SINGLE_COMMENT_START), text.indexOf("\n", text.indexOf(SINGLE_COMMENT_START)), "");
        } catch (StringIndexOutOfBoundsException e) {

        }
        return text;
    }
}
