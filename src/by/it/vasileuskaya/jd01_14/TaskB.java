package by.it.vasileuskaya.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskB {

    public static final String SRC = "src";
    public static final String USER_DIR = "user.dir";
    public static final String FILENAME = "Poem.txt";
    public static final String RESULT_TXT = "resultTaskB.txt";

    public static void main(String[] args) {
        String path = getFileName(FILENAME);
        List<String> stringsText = readFromTxtFile(path);
        int countWords = findCountWords(stringsText);
        int countPunctualMarks = findCountPunctualMarks(stringsText);
        System.out.printf("words=%d, punctual marks=%d", countWords, countPunctualMarks);
        path = getFileName(RESULT_TXT);
        printResultToFile(path, countWords, countPunctualMarks);
    }

    private static void printResultToFile(String path, int countWords, int countPunctualMarks) {
        try (PrintWriter out =
                     new PrintWriter(path)) {
            out.printf("words=%d, punctual marks=%d", countWords, countPunctualMarks);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int findCountPunctualMarks(List<String> text) {
        int countPunctualMarks = 0;
        for (String value : text) {
            String replace = value.replaceAll("[A-ЯЁа-яё\n\s]", "").replace("...", ".");
            countPunctualMarks += replace.length();
        }
        System.out.println(countPunctualMarks);
        return countPunctualMarks;
    }

    private static int findCountWords(List<String> text) {
        int countWords = 0;
        for (String value : text) {
            String replace = value.replaceAll("[^A-ЯЁа-яё\s\n]", "").replace("  ", " ");
            String[] split = replace.split(" ");
            countWords += split.length;
        }
        System.out.println(countWords);
        return countWords;
    }

    private static List<String> readFromTxtFile(String path) {
        List<String> list = new ArrayList<>();
        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                line = bufferedReader.readLine();
                list.add(line);
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private static String getFileName(String fileName) {
        String projectRoot = System.getProperty(USER_DIR);
        Class<TaskB> taskBClass = TaskB.class;
        String name = taskBClass.getName();
        String path = name.replace(taskBClass.getSimpleName(), "")
                .replace(".", File.separator);
        path = projectRoot + File.separator + SRC + File.separator + path;
        return path + fileName;
    }
}
