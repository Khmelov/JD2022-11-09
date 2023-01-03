package by.it.han.jd01_14;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    private static final String FILE_NAME = "Poem.txt";
    private static final String RESULT_FILE_NAME = "resultTaskB.txt";

    public static void main(String[] args) {

        String poem = getStringFromFile();
        int countWords = getCountWords(poem);
        int countPunctuationMarks = getCountPunctuationMarks(poem);
        String form = "words=%d, punctuation marks=%d";
        System.out.printf(form, countWords, countPunctuationMarks);
        writeToResultFile(form, countWords, countPunctuationMarks);
    }

    private static void writeToResultFile(String form, int countWords, int countPunctuationMarks) {
        String filePath = TaskA.getFilePath(RESULT_FILE_NAME);
        try (PrintStream out = new PrintStream(filePath)) {
            out.printf(form, countWords, countPunctuationMarks);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int getCountWords(String poem) {
        List<String> list = new ArrayList<>();
        Pattern pattern = Pattern.compile("[А-Яа-яЁё]+");
        Matcher matcher = pattern.matcher(poem);
        while (matcher.find()) {
            list.add(matcher.group());
        }
        return list.size();
    }

    private static int getCountPunctuationMarks(String poem) {
        String[] punctuationMarks = poem
                .replaceAll("[А-Яа-яЁё]", " ")
                .replace("...", " ")
                .split("\\s+");
        return punctuationMarks.length;
    }

    private static String getStringFromFile() {
        String filePath = TaskA.getFilePath(FILE_NAME);
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader fileReader = new FileReader(filePath)) {
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()) {
                stringBuilder
                        .append(scanner.nextLine())
                        .append(" ");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder.toString();
    }
}
