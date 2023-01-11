package by.it.yaroshevich.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class TaskA {
    public static  final  String FILENAME = "dataTaskA.bin";
    public static  final  String RESULT_TXT = "resultTaskA.txt";

    public static void main(String[] args){
        Locale.setDefault(Locale.UK);
        String path = getFilePath(FILENAME);
        writeToBineryFile(path);
        List<Integer> list = readFromBinaryFile(path);
        writeToConsole(list);
        path = getFilePath(RESULT_TXT);
        printToTXTFile(path, list);
    }

    private static void printToTXTFile(String path, List<Integer> list) {
        try (PrintWriter out = new PrintWriter(path)){
            double sum = 0;
            for (Integer value: list){
                sum+=value;
                out.printf("%d ", value);
            }
            out.printf("\navg=%f%n",sum/ list.size());

        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    private static void writeToConsole(List<Integer> list) {
        double sum = 0;
        for (Integer value: list){
            sum+=value;
            System.out.printf("%d ", value);
        }
        System.out.printf("\navg=%f%n",sum/ list.size());
    }

    private static List<Integer> readFromBinaryFile(String path) {
        List<Integer>list=new ArrayList<>();
        try (DataInputStream dataInputStream =
                new DataInputStream(new BufferedInputStream(new FileInputStream(path)))){
        while (dataInputStream.available()>0){
            int valueInput = dataInputStream.readInt();
            list.add(valueInput);
        }
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        return list;
    }

    private static void writeToBineryFile(String path) {
        try (DataOutputStream dataOutputStream =
                     new DataOutputStream(
                        new BufferedOutputStream(
                            new FileOutputStream(path)
                        )
                     )
        ) {

            for (int i = 0; i < 20; i++) {
                int value = ThreadLocalRandom.current().nextInt(0, 1000);
            dataOutputStream.writeInt(value);
            }

        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    private static String getFilePath(String filename) {
        String projectRoot = System.getProperty("user.dir");
        Class<TaskA> taskAClass = TaskA.class;
        String name = taskAClass.getName();
        String path = name
                .replace(taskAClass.getSimpleName(), "")
                .replace(".", File.separator);
        path = projectRoot+File.separator + "src" + File.separator + path;
    return path  + filename;
    }
}
