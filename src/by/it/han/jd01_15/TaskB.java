/*ыфвфыasdw*/
package by.it.han.jd01_15; //myClass /*
// sadsdqwqwdqwd*/

import java.io.*;

/**
 * asadsa
 * weq/
 * ////
 */
public class TaskB {
    private static /*sadsdqwqwdqwd*/ final String RESULT_FILE_NAME = "TaskB.txt";/*sadsdqwqwdqwd*/
    private static final String FILE_NAME = "TaskB.java";
    private static boolean skipManyLine = false;
    private static final char SLASH = '/';
    private static final char STAR = '*';

    //it's the main method
    public static/*sadsdqwqwdqwd*/ void main(String[] args) {
        //search File in Path
        String filePath = PatchFinder.getFilePath(FILE_NAME, TaskB.class);
        String resultFilePath = PatchFinder.getFilePath(RESULT_FILE_NAME, TaskB.class);
        StringBuilder programText = getProgramText(filePath);
        System.out.println(programText);
        saveToFile(resultFilePath, programText);/* save file
         asdasd
         adw
         a
         */


        /*
        asdqw
         */
    }

    private static void saveToFile(String resultFilePath, StringBuilder programText) {
        try (PrintWriter out = new PrintWriter(resultFilePath)) {
            out.println(programText);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static StringBuilder getProgramText(String filePath) {
        StringBuilder programText = new StringBuilder();
        try (BufferedReader bufferedReader =
                     new BufferedReader(
                             new InputStreamReader(
                                     new FileInputStream(filePath)))) {
            while (bufferedReader.ready()) {
                StringBuilder programLine = getProgramLine(bufferedReader);
                programText.append(programLine);
//                if (!programLine.equals(""))
                programText.append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return programText;
    }

    private static StringBuilder getProgramLine(BufferedReader bufferedReader) throws IOException {
        String readLine = bufferedReader.readLine();
        StringBuilder programLine = new StringBuilder();
        byte[] symbols = readLine.getBytes();//asd
        if (symbols.length > 0) {
            for (int i = 0; i < symbols.length - 1; i++) {
                boolean isOneLineComment = symbols[i] == SLASH && symbols[i + 1] == SLASH;
                boolean isStartManyLineComment = symbols[i] == SLASH && symbols[i + 1] == STAR;
                boolean isEndManyLineComment = symbols[i] == STAR && symbols[i + 1] == SLASH;
                if (isOneLineComment) {
                    return programLine;
                }
                if (isStartManyLineComment) {
                    skipManyLine = true;
                } else if (isEndManyLineComment) {
                    skipManyLine = false;
                    continue;
                } else if (!skipManyLine && symbols[i] != SLASH) {
                    programLine.append((char) symbols[i]);
                }
                if (i == symbols.length - 2 && !skipManyLine) {
                    programLine.append((char) symbols[i + 1]);
                }
            }
        }
        return programLine;
    }
}
