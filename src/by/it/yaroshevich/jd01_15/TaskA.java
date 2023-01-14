package by.it.yaroshevich.jd01_15;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TaskA {
    public static final int MAX_VALUE = 15;
    public static final int ROWS = 6;
    public static final int COLS = 4;
    public static final String FILENAME = "matrix.txt";

    public static void main(String[] args) {
        int[][] matrix = generateRandomMatrix();
        String filePath = PathFinder.getFilePath(FILENAME, TaskA.class);
        saveMatrixToFile(matrix, filePath);
        showToConsole(filePath);
    }
        private static void showToConsole(String filePath){
            try {
                List<String> lines = Files.readAllLines(Path.of(filePath));
                for (String line : lines) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }

    private static void saveMatrixToFile (int[][] matrix, String filePath){
        try (PrintWriter writer = new PrintWriter(filePath)) {
            for (int[] row : matrix) {
                for (int element : row) {
                    writer.printf("%3d ", element);
                }
                writer.println();
            }
        } catch (
                FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[][] generateRandomMatrix() {

        int[][] matrix = new int[ROWS][COLS];

        for (int j = 0; j < matrix.length; j++) {
            for (int i = 0; i < matrix[j].length; i++) {
                matrix[j][i] = ThreadLocalRandom
                        .current()
                        .nextInt(-1 * MAX_VALUE, MAX_VALUE + 1);
            }
        }
        return matrix;
    }
}

