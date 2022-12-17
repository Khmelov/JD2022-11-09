package by.it.bolshakov.jd01_09;

import java.util.Scanner;

public class InputConsole implements Input {
    private final Scanner scanner;

    public InputConsole(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String getInput() {
        String line = scanner.nextLine();
        line = line.replaceAll("\\s+", "");
        return line.equals("end")
                ? null
                : line;
    }
}
