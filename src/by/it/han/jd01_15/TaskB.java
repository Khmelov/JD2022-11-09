package by.it.han.jd01_15;

import java.io.*;

/**
 * @author "Han"
 * @version 9
 */
public class TaskB {

    private static final String RESULT_FILE_NAME = "TaskB.txt";
    private static final String FILE_NAME = "TaskB.java";
    private static boolean isManyLineComment = false;
    private static final char SLASH = '/';
    private static final char STAR = '*';

    //it's the main method
    public static void main(String[] args) {
        //search File in Path
        String filePath = PatchFinder.getFilePath(FILE_NAME, TaskB.class);
        String resultFilePath = PatchFinder.getFilePath(RESULT_FILE_NAME, TaskB.class);
        StringBuilder programText = new StringBuilder();
        addProgramTextToStringBuilder(filePath, programText);

        try (PrintWriter out = new PrintWriter(resultFilePath)) {
            out.println(programText);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(programText);
        /*
        save file
         */

        /*
        asdqw
         */
    }

    private static void addProgramTextToStringBuilder(String filePath, StringBuilder programText) {
        try (BufferedReader bufferedReader =
                     new BufferedReader(
                             new InputStreamReader(
                                     new FileInputStream(filePath)))) {
            while (bufferedReader.ready()) {
                String programLine = getProgramLine(bufferedReader);
                if (programLine == null) continue;
                programText.append(programLine).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getProgramLine(BufferedReader bufferedReader) throws IOException {
        String readLine = bufferedReader.readLine();
        boolean isEmptyString = getCondition(readLine, 0, ' ');
        boolean isFirstCharSlash = getCondition(readLine, 0, SLASH);
        boolean isSecondCharSlash = getCondition(readLine, 1, SLASH);
        boolean isSecondCharStar = getCondition(readLine, 1, STAR);
        boolean isLastCharSlash = getCondition(readLine, readLine.trim().length() - 1, SLASH);
        boolean isPreLastCharStar = getCondition(readLine, readLine.trim().length() - 2, STAR);
        if (!isEmptyString && isFirstCharSlash && isSecondCharSlash) {
            return null;
        } else if ((isManyLineComment || !isEmptyString && isFirstCharSlash && isSecondCharStar)) {
            isManyLineComment = !isPreLastCharStar || !isLastCharSlash;
            return null;
        }
        return readLine;
    }

    private static boolean getCondition(String str, int number, char symbol) {
        if (str.trim().length() < 2) {
            return false;
        }
        return str.trim().getBytes()[number] == symbol;
    }
}
