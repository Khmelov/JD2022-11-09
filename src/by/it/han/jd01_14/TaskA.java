package by.it.han.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TaskA {

    private static final String FILE_NAME = "dataTaskA.bin";
    private static final String FILE_RESULT = "resultTaskA.txt";
    private static final int countNumber = 20;

    public static void main(String[] args) {
        String filePath = getFilePath(FILE_NAME);
        List<Integer> list = new ArrayList<>(countNumber);
        writeToBinFile(filePath);
        readFromFile(filePath, list);
        printToConsole(list);
        writeToResultFile(list);
    }

    private static void writeToBinFile(String filePath) {
        try (DataOutputStream dataOutputStream =
                     new DataOutputStream(
                             new BufferedOutputStream(
                                     new FileOutputStream(filePath)))) {
            for (int i = 0; i < 20; i++) {
                int number = ThreadLocalRandom.current().nextInt(0, 100);
                dataOutputStream.writeInt(number);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void readFromFile(String filePath, List<Integer> list) {
        try (DataInputStream dataInputStream =
                     new DataInputStream(
                             new BufferedInputStream(
                                     new FileInputStream(filePath)))) {
            while (dataInputStream.available() > 0) {
                int value = dataInputStream.readInt();
                list.add(value);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printToConsole(List<Integer> list) {
        double sum = 0;
        for (Integer integer : list) {
            sum += integer;
            System.out.print(integer + " ");
        }
        System.out.printf("\navg=%s%n", sum / list.size());
    }

    private static void writeToResultFile(List<Integer> list) {
        String filePath;
        double sum = 0;
        filePath = getFilePath(FILE_RESULT);
        try (PrintStream out = new PrintStream(filePath)) {
            for (Integer integer : list) {
                sum += integer;
                out.print(integer + " ");
            }
            out.printf("\navg=%s%n", sum / list.size());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getFilePath(String fileName) {
        String projectRoot = System.getProperty("user.dir");
        Class<?> taskAClass = TaskA.class;
        String name = taskAClass.getName();
        String path = name.replace(taskAClass.getSimpleName(), "")
                .replace('.', File.separatorChar);
        path = projectRoot + File.separatorChar + "src" + File.separatorChar + path;
        return path + fileName;
    }


}
