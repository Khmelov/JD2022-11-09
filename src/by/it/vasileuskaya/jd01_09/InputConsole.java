package by.it.vasileuskaya.jd01_09;

import java.util.Scanner;

public class InputConsole implements Input {

    public final Scanner scanner;

    public InputConsole(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String getCommand() {
        String line = scanner.nextLine();
        line = line.replaceAll("\\s+", "");

        return line.equals("end")
                ? null
                : line;
    }
}
