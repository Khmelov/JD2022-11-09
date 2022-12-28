package by.it.samatokhin.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TaskA {

    public static final String FILENAME = "dataTaskA.bin";
    public static final String RESULT_TXT = "resultTaskA.txt";
    public static final String USER_DIR = "user.dir";
    public static final String SRC = "src";

    public static void main(String[] args) {
        String path = getFilePath(FILENAME);
        writeToBinaryFile(path);
        List<Integer> list = readFromBinaryFile(path);
        writeToConsole(list);
        path = getFilePath(RESULT_TXT);
        writeToTxtFile(path, list);
    }

    private static void writeToTxtFile(String path, List<Integer> list) {
        try (PrintWriter out = new PrintWriter(path)) {
            double sum = 0;
            for (Integer value : list) {
                sum += value;
                out.printf("%d ", value);
            }
            out.printf("\navg=%f%n", sum / list.size());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeToConsole(List<Integer> list) {
        double sum = 0;
        for (Integer value : list) {
            sum += value;
            System.out.printf("%d ", value);
        }
        System.out.print("\navg=" + sum / list.size());
        System.out.printf("\navg=%f%n", sum / list.size());
    }

    private static List<Integer> readFromBinaryFile(String path) {
        List<Integer> list = new ArrayList<>();
        try (DataInputStream dataInputStream =
                     new DataInputStream(new BufferedInputStream(new FileInputStream(path)))) {
            while (dataInputStream.available() > 0) {
                int value = dataInputStream.readInt();
                list.add(value);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    private static void writeToBinaryFile(String path) {
        try (
                DataOutputStream dataOutputStream =
                        new DataOutputStream(new BufferedOutputStream(new FileOutputStream(path)))) {
            for (int i = 0; i < 20; i++) {
                int intValue = ThreadLocalRandom.current().nextInt(0, 1000);
                dataOutputStream.writeInt(intValue);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getFilePath(String filename) {
        String projectRoot = System.getProperty(USER_DIR);
        Class<TaskA> taskAClass = TaskA.class;
        String name = taskAClass.getName();
        String path = name
                .replace(taskAClass.getSimpleName(), "")
                .replace(".", File.separator);
        path = projectRoot + File.separator + SRC + File.separator + path;
        return path + filename;
    }
}
