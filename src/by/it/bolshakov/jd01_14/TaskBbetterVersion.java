package by.it.bolshakov.jd01_14;

import java.io.*;
import java.util.Scanner;
import java.util.regex.MatchResult;

import static by.it.bolshakov.jd01_14.TaskA.getFilePath;

public class TaskBbetterVersion {

    private static final String PATH = getFilePath("Poem.txt");
    private static final String OUTPUT_PATH = getFilePath("resultTaskB.txt");
    private static final String WORD_REGEX = "[a-zA-Zа-яА-ЯЁё]+";
    private static final String DELIMITER_REGEX = "[\\p{P}]+";
    
    public static void main(String[] args) {
        long wordsSum = 0;
        long delimSum = 0;

        try (FileReader reader = new FileReader(PATH)) {
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                wordsSum+=parseLine(WORD_REGEX, line);
                delimSum+=parseLine(DELIMITER_REGEX, line);
            }
            System.out.printf("words=%d, punctuation marks=%d", wordsSum, delimSum);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try (PrintWriter out = new PrintWriter(OUTPUT_PATH)) {
            out.printf("words=%d, punctuation marks=%d", wordsSum, delimSum);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static long parseLine(String wordRegex, String line) {
        Scanner scanner = new Scanner(line);
        return scanner.findAll(wordRegex).map(MatchResult::group).count();
    }
}
