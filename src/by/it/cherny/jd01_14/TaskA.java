package by.it.cherny.jd01_14;

import java.io.*;
import java.util.concurrent.ThreadLocalRandom;

public class TaskA {

    public static final String FILENAME = "dataTaskA.bin";

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
        try (
        DataInputStream dataInputStream =
                new DataInputStream(
                    new BufferedInputStream(
                        new FileInputStream(path)))
        ){

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getFilePath(String filename) {
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
