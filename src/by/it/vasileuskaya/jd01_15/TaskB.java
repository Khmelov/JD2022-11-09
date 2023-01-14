package by.it.vasileuskaya.jd01_15;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author vasileuskaya
 */
public class TaskB {
    //the first my comment
    public static final int MAX_VALUE = 15;
    public static final int ROWS = 6;
    public static final int COLS = 4;
    public static final String FILENAME = "matrix.txt";

    public static void main(String[] args) {
        int[][] matrix = fillMatrix();
        String filePath = PathFinder.getFilePath(FILENAME);
        saveMatrixToFile(matrix, filePath);
        showFileInConsole(filePath);
        readText();
    }

    private static void readText() {
        String taskB = PathFinder.getFilePath("TaskB");
        StringBuilder stringBuilder = new StringBuilder();


    }

    //the second my comment
    private static int[][] fillMatrix() {
        int[][] matrix = new int[ROWS][COLS];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = ThreadLocalRandom
                        .current()
                        .nextInt(-MAX_VALUE, MAX_VALUE + 1);
            }
        }
        return matrix;
    }

    /*
    long comments
    very long comments
     */
    private static void saveMatrixToFile(int[][] matrix, String filePath) {
        try (PrintWriter writer = new PrintWriter(filePath)) {
            for (int[] row : matrix) {
                for (int element : row) {
                    writer.printf("%3d ", element);
                }
                writer.println();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /* delete this long comment
    this comment need to delete
     */
    private static void showFileInConsole(String filePath) {
        try {
            List<String> lines = Files.readAllLines(Path.of(filePath));
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
