package by.it.cherny.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    public static final String FILENAME = "Poem.txt";
    public static final String RESULT_FILENAME = "resultTaskB.txt";

    public static void main(String[] args) {
        String path = getFilePath(FILENAME);
        String text = getTextFromFile(path);

        int marks = getCountOfPunctuationMarks(text);
        int words = getCountOfWords(text);

        System.out.printf("words=%d, punctuation marks=%d", words, marks);

        String resultPath = getFilePath(RESULT_FILENAME);
        printToFile(marks, words, resultPath);
    }

    private static void printToFile(int marks, int words, String path) {
        try (FileWriter writer = new FileWriter(path))
        {
            writer.write("words="+words+", punctuation marks="+marks);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int getCountOfWords(String text) {
        int counter = 0;
        Pattern pattern = Pattern.compile("[А-Яа-яЁё]+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            counter++;
        }
        return counter;
    }

    private static int getCountOfPunctuationMarks(String text) {
        int counter = 0;
        Pattern pattern = Pattern.compile("[^А-Яа-яЁё\\s]+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
            counter++;
        }
        return counter;
    }

    private static String getTextFromFile(String path) {
        StringBuilder stringBuilder = new StringBuilder();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                stringBuilder.append(line).append(System.lineSeparator());
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder.toString();
    }

    private static String getFilePath(String filename) {
        String projectRoot = System.getProperty("user.dir");
        Class<TaskB> taskBClass = TaskB.class;
        String name = taskBClass.getName();
        String path = name
                .replace(taskBClass.getSimpleName(), "")
                .replace(".", File.separator);
        path=projectRoot+File.separator+"src"+File.separator+path;
        return path+filename;
    }
}
