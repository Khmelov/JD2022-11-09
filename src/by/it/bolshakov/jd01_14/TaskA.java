package by.it.bolshakov.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TaskA {
    private static final String FILENAME = "dataTaskA.bin";
    private static final String RESULT_TXT = "resultTaskA.txt";

    public static void main(String[] args) {
        String path = getFilePath(FILENAME);
        printToBinary(path);
        List<Integer> numbersList = readFromBinary(path);
        printArrayAndAvg(numbersList);
        path = getFilePath(RESULT_TXT);
        printToFile(path, numbersList);
    }

    private static void printArrayAndAvg(List<Integer> numbersList) {
        double sum = 0;
        for (Integer number : numbersList) {
            sum+=number;
            System.out.printf("%d ", number);
        }
        System.out.println();
        System.out.println("avg="+sum/ numbersList.size());
    }

    private static List<Integer> readFromBinary(String path) {
        List<Integer> numbersList = new ArrayList<>();

        try (DataInputStream din = new DataInputStream(new BufferedInputStream(new FileInputStream(path)))) {
            while (din.available() > 0) {
                numbersList.add(din.readInt());
            }
        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлом: " + e.getMessage());
        }
        return numbersList;
    }

    private static void printToBinary(String path) {
        try (DataOutputStream dos = new DataOutputStream(
                                        new BufferedOutputStream(
                                                new FileOutputStream(path)
                                                )
                                        )
        ) {
            for (int i = 0; i < 20; i++) {
                int number = ThreadLocalRandom.current().nextInt();
                dos.writeInt(number);
            }
        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлом: " + e.getMessage());
        }
    }

    public static void printToFile(String path, List<Integer> numbersList) {
        try (PrintWriter out = new PrintWriter(path)) {
            double sum = 0;
            for (Integer number : numbersList) {
                sum+=number;
                System.out.printf("%d ", number);
            }
            out.println();
            out.println("avg="+ sum / numbersList.size());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getFilePath(String filename) {
        String projectRoot = System.getProperty("user.dir");
        Class<TaskA> taskAClass= TaskA.class;
        String path = taskAClass.getName();
        path = path.replace(taskAClass.getSimpleName(), "")
                    .replace(".", File.separator);
        path = projectRoot + File.separator + "src" + File.separator + path;
        return path + filename;
    }
}
