package by.it.samatokhin.jd01_15;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TaskB {
    // This is a single line comment
    public static String className;

    // This is a single line comment 2
    public static void main(String[] args) throws IOException {
        StringBuilder textOfClass = grabClassText();
        textOfClass = removeComment(textOfClass, 0);

        printToTxtFile(textOfClass);
        printToConsole(textOfClass);
    }

    private static StringBuilder removeComment(StringBuilder textOfClass, int scannedPosition) {

        int removeStart = 0, removeEnd = 0;
        boolean found = false;

        for (int i = scannedPosition; i < textOfClass.length(); i++) {
            if (textOfClass.charAt(i) == '/') {
                removeStart = i;
                if (textOfClass.charAt(i + 1) == '/') {
                    for (int x = i + 2; x < textOfClass.length(); x++) {
                        if (textOfClass.charAt(x) == (char) 0x0A) {
                            removeEnd = x;
                            found = true;
                            break;
                        }
                    }
                } else if (textOfClass.charAt(i + 1) == '*') {
                    for (int x = i + 2; x < textOfClass.length(); x++) {
                        if (textOfClass.charAt(x) == '/') {
                            removeEnd = x + 1;
                            found = true;
                            break;
                        }
                    }
                }
            }
            if (found) {
                break;
            }
        }
        if (found) {
            textOfClass = textOfClass.delete(removeStart, removeEnd);
            textOfClass = removeComment(textOfClass, removeStart);
        }
        return textOfClass;
    }

    /*
        This is a regular multi-line comment
     */
    private static StringBuilder grabClassText() {
        Class thisClass = new Object() {
        }.getClass();
        className = thisClass.getEnclosingClass().getSimpleName();
        String path = PathFinder.getFilePath(className + ".java", TaskB.class);

        StringBuilder stringBuilder = new StringBuilder();
        String separator = System.getProperty("line.separator");
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            for (String str : lines) {
                stringBuilder.append(str);
                stringBuilder.append(separator);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.deleteCharAt(stringBuilder.length() - 1);
    }
    /*
         This is a regular multi-line comment 2
     */

    /**
     * This is a Javadoc
     */
    private static void printToTxtFile(StringBuilder result) {
        String path = PathFinder.getFilePath(className + ".txt", TaskB.class);
        try (PrintWriter out = new PrintWriter(path)) {
            out.printf(result.toString().trim());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printToConsole(StringBuilder result) {
        System.out.println(result);
    }
}
