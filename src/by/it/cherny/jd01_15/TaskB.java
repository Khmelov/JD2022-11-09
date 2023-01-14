package by.it.cherny.jd01_15;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TaskB {
    public static final String STRING_COMMENT = "//";
    public static final String BLOCK_COMMENT_STARTS = "/*";
    public static final String BLOCK_COMMENT_ENDS = "*/";

    public static void main(String[] args) {
        // comment1
        // comment2
        /*
            comment3
         */
        /*
            comment4
         */ int b;
        /**JavaDoc*/ int a;
        StringBuilder builder = new StringBuilder();
        String path = PathFinder.getFilePath("TaskB.java", TaskB.class);
        try {
            List<String> lines = Files.readAllLines(Path.of(path));

            for (int i=0; i<lines.size();i++) {
                if (lines.get(i).contains(STRING_COMMENT)&&!lines.get(i).contains("STRING_COMMENT")){
                    String str = lines.get(i)
                            .substring(0, lines.get(i).indexOf(STRING_COMMENT));
                    builder.append(str).append(System.lineSeparator());

                } else if (lines.get(i).contains(BLOCK_COMMENT_STARTS)&&!lines.get(i).contains("BLOCK_COMMENT_STARTS")) {
                    String firstPart = lines.get(i).substring(0, lines.get(i).indexOf(BLOCK_COMMENT_STARTS));
                    while (!lines.get(i).contains(BLOCK_COMMENT_ENDS)){
                        i++;
                    }
                    String secondPart = lines.get(i)
                            .substring(lines.get(i).indexOf(BLOCK_COMMENT_ENDS)+2);
                    builder.append(firstPart).append(secondPart).append(System.lineSeparator());
                } else if (lines.get(i).contains("STRING_COMMENT")||lines.get(i).contains("BLOCK_COMMENT")) {
                    String line = lines.get(i).replace(STRING_COMMENT, " ")
                            .replace(BLOCK_COMMENT_STARTS, " ")
                            .replace(BLOCK_COMMENT_ENDS, " ");
                    builder.append(line).append(System.lineSeparator());
                } else {
                    builder.append(lines.get(i)).append(System.lineSeparator());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(builder);
        String filePath = PathFinder.getFilePath("TaskB.txt", TaskB.class);
        System.out.println(filePath);
        dublicateIntoFile(filePath, String.valueOf(builder));
    }

    private static void dublicateIntoFile(String filePath, String text) {
        try (FileWriter writer = new FileWriter(filePath)){
            writer.write(text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
