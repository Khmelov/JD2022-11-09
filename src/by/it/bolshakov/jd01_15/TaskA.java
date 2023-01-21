package by.it.bolshakov.jd01_15;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TaskA {

    public static final int MAX_VALUE = 15;
    public static final int ROWS = 6;
    public static final int COLS = 4;
    public static final String filename = "matrix.txt";

    public static void main(String[] args) {
        int[][] matrix = generateRandomMatrix();
        String filepath = PathFinder.getFilePath(filename, TaskA.class);
        writeMatrixToFile(matrix, filepath);
        printFileInConsole(filepath);
    }
    private static void printFileInConsole(String filepath) {
        try {
            List<String> lines = Files.readAllLines(Path.of(filepath));
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeMatrixToFile(int[][] matrix, String filepath) {
        try (PrintWriter writer = new PrintWriter(filepath)) {
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

    private static int[][] generateRandomMatrix() {
        int[][] matrix = new int[ROWS][COLS];
        for (int[] row: matrix) {
            for (int i = 0; i < row.length; i++) {
                row[i] = ThreadLocalRandom
                        .current()
                        .nextInt(-1 * MAX_VALUE, MAX_VALUE + 1);
            }
        }
        return matrix;
    }
}
