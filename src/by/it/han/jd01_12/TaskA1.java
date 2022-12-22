package by.it.han.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TaskA1 {

    private static final int SIZE = 20;
    private final List<Integer> grades = new ArrayList<>(SIZE);

    public static void main(String[] args) {
        TaskA1 taskA1 = new TaskA1();
        fillArray(taskA1);
        System.out.println(taskA1.grades);
        taskA1.clearBad(taskA1.grades);
        System.out.println(taskA1.grades);
    }

    private void clearBad(List<Integer> grades) {
        Iterator<Integer> iterator = grades.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() < 4) {
                iterator.remove();
            }
        }
    }

    private static void fillArray(TaskA1 taskA1) {
        for (int i = 0; i < SIZE; i++) {
            taskA1.grades.add(ThreadLocalRandom.current().nextInt(1, 11));
        }
    }
}
