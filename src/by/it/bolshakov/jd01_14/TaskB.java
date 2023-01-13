package by.it.bolshakov.jd01_14;

import java.io.*;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;

import static by.it.bolshakov.jd01_14.TaskA.getFilePath;

public class TaskB {
    public static void main(String[] args) {

        String path = getFilePath("Poem.txt");
        String outPath = getFilePath("resultTaskB.txt");
        String wordRegex = "[a-zA-Zа-яА-ЯЁё]+";
        String delimRegex = "[\\p{P}]+";
        System.out.printf("words=%d, punctuation marks=%d",scanTxt(path, wordRegex).size(), scanTxt(path, delimRegex).size());

        try (PrintWriter out = new PrintWriter(outPath)) {
            out.printf("words=%d, punctuation marks=%d",scanTxt(path, wordRegex).size(), scanTxt(path, delimRegex).size());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static List<String> scanTxt(String path, String regex) {
        List<String> matches;
        try (Scanner file = new Scanner(Paths.get(path))) {
            matches = file.findAll(regex).map(MatchResult::group).toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return matches;
    }
}
