package by.it.samatokhin.jd01_14;

import java.io.File;

public class TaskA {
    public static void main(String[] args) {
        String projectRoot = System.getProperty("user.dir");
        Class<TaskA> taskAClass = TaskA.class;
        String name = taskAClass.getName();
        String path = name
                .replace(taskAClass.getSimpleName(), "")
                .replace(".", File.separator);
        path = projectRoot + File.separator + "src" + File.separator + path;
        System.out.println(path);
    }
}
