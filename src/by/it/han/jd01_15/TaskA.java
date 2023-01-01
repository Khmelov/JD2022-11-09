package by.it.han.jd01_15;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TaskA {
    private static final int COL_COUNT = 4;
    private static final int ROW_COUNT = 6;
    private static final int MAX_VALUE = 15;
    private static final String FILE_NAME = "matrix.txt";
    private static final String FORMAT = "%3d ";

    public static void main(String[] args) {
        String filePath = PatchFinder.getFilePath(FILE_NAME, TaskA.class);
        int[][] matrix = getRandomMatrix();
        saveMatrixToFile(filePath, matrix);
        printFileToConsole(filePath);
    }

    private static void printFileToConsole(String filePath) {
        try {
            List<String> list = Files.readAllLines(Path.of(filePath));
            for (String s : list) {
                System.out.println(s);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void saveMatrixToFile(String filePath, int[][] matrix) {
        try (PrintWriter out = new PrintWriter(filePath)) {
            for (int[] rows : matrix) {
                for (int val : rows) {
                    out.printf(FORMAT, val);
                }
                out.println();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[][] getRandomMatrix() {
        int[][] matrix = new int[ROW_COUNT][COL_COUNT];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = ThreadLocalRandom.current().nextInt(-MAX_VALUE, MAX_VALUE + 1);
            }
        }
        return matrix;
    }
}
