package by.it.cherny.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TaskA {

    public static final String FILENAME = "dataTaskA.bin";
    public static final String FILENAME_CONSOLE = "resultTaskA.txt";

    public static void main(String[] args){
        String path = getFilePath(FILENAME);
        // full pathname to file^^
        try (DataOutputStream dataOutputStream =
                 new DataOutputStream( //Integer values
                    new BufferedOutputStream( // add bufferization
                        new FileOutputStream(path)) // write to file
                 )
        ){
            for (int i = 0; i < 20; i++) {
//                dataOutputStream.write(Integer.parseInt(String.valueOf(Math.random()*(100+1))));
                dataOutputStream.writeInt(ThreadLocalRandom.current().nextInt(0, 1000));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // read binary file
        List<Integer> list = new ArrayList<>();
        try (
            DataInputStream dataInputStream =
                new DataInputStream(
                    new BufferedInputStream(
                        new FileInputStream(path))
                )
        ){
            while (dataInputStream.available()>0){
                int value = dataInputStream.readInt();
                list.add(value);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // write to console
        for (Integer integer : list) {
            System.out.printf("%d ", integer);
        }
        System.out.println();
        // ------- average -------
        double average=0;
        for (Integer integer : list) {
            average+=integer;
        }
        average=average/ list.size();
        System.out.println("avg="+average);

        // -------------- write to file -----------------
        String path_console = getFilePath(FILENAME_CONSOLE);
        // full pathname to file^^
        try (FileWriter writer = new FileWriter(path_console)) {
            for (Integer integer : list) {
//                System.out.println(integer);
                writer.write(integer+" ");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getFilePath(String filename) {
        String projectRoot = System.getProperty("user.dir");
        Class<TaskA> taskAClass = TaskA.class;
        String name = taskAClass.getName();
        System.out.println(name);
        String path = name
                .replace(taskAClass.getSimpleName(), "")
                .replace(".", File.separator);
        path=projectRoot+File.separator+"src"+File.separator+path;
        return path+filename;
    }
}
