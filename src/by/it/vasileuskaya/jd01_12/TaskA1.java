package by.it.vasileuskaya.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TaskA1 {
    private ArrayList<Integer> grades = new ArrayList<>();

    public static void main(String[] args) {
        TaskA1 solver = new TaskA1();
        fillGrades(solver);
    }

    private static void fillGrades(TaskA1 solver) {
        int size = ThreadLocalRandom.current().nextInt(15, 30);
        for (int i = 0; i < size; i++) {
            int grade = ThreadLocalRandom.current().nextInt(1, 11);
            solver.grades.add(grade);
        }
        System.out.println(solver.grades);
        solver.clearBad(solver.grades);
        System.out.println(solver.grades);
    }

    private void clearBad(List<Integer> grades) {
        Iterator<Integer> iterator = grades.iterator();
        //noinspection Java8CollectionRemoveIf
        while (iterator.hasNext()) {
            Integer currentGrade = iterator.next();
            if (currentGrade < 4) {
                iterator.remove();
            }
        }
    }
}
