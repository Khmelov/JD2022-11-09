package by.it.cherny.jd01_14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TaskC {
    private static final StringBuilder builder = new StringBuilder();

    public static void main(String[] args) {
        String SR = File.separator;
        String projectRoot = System.getProperty("user.dir");
//        TaskC.class.getPackage().;
        String path = projectRoot+SR+"src"+SR+"by"+SR+"it"+SR+"cherny"+SR;
        File file = new File(path);
        listFilesForFolder(file);
        String filePath = TaskA.getFilePath("resultTaskC.txt");
        dublicateIntoFile(filePath);
    }

    private static void dublicateIntoFile(String filePath) {
        try (FileWriter writer = new FileWriter(filePath)){
            writer.write(String.valueOf(builder));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void listFilesForFolder(File folder) {
        for (File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                builder.append("dir:").append(fileEntry.getName()).append(System.lineSeparator());
                System.out.println("dir:"+fileEntry.getName());
                listFilesForFolder(fileEntry);
            } else {
                builder.append("file:").append(fileEntry.getName()).append(System.lineSeparator());
                System.out.println("file:"+fileEntry.getName());
            }
        }
    }
}
