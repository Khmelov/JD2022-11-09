package by.it.samatokhin.jd01_14;

import by.it.samatokhin.jd01_15.PathFinder;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TaskB {

    public static final String FILENAME = "Poem.txt";
    public static final String RESULT_TXT = "resultTaskB.txt";

    public static void main(String[] args) throws IOException {

        String path = PathFinder.getFilePath(FILENAME, TaskB.class);
        List<String> lines = Files.readAllLines(Paths.get(path));

        int wordsCount = countWords(lines);
        int punctuationsCount = countPunctuations(lines);

        String result = "words=" + wordsCount + ", punctuation marks=" + punctuationsCount;

        writeToConsole(result);
        printToTxtFile(result);
    }

    private static int countWords(List<String> lines) {
        int wordsCount = 0;
        for (String line : lines) {
            String[] words = line.replaceAll("[^а-яёА-ЯЁ0-9]", " ").toLowerCase().split("\\s+");
            wordsCount = wordsCount + words.length;
        }
        return wordsCount;
    }

    private static int countPunctuations(List<String> lines) {
        int punctuationsCount = 0;
        for (String line : lines) {
            String[] words = line.replaceAll("[а-яёА-ЯЁ0-9]", " ").toLowerCase().split("\\s+");
            int punctuationsCountInner = 0;
            for (String str : words) {
                if (!str.equals("")) {
                    punctuationsCountInner++;
                }
            }
            punctuationsCount = punctuationsCount + punctuationsCountInner;
        }
        return punctuationsCount;
    }

    private static void printToTxtFile(String result) {
        String path = PathFinder.getFilePath(RESULT_TXT, TaskB.class);
        try (PrintWriter out = new PrintWriter(path)) {
            out.printf(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeToConsole(String result) {
        System.out.println(result);
    }
}
