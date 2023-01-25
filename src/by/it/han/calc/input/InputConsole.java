package by.it.han.calc.input;

import java.util.Scanner;

public class InputConsole implements Input {

    private final Scanner scanner;

    public InputConsole(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String input() {
        String line = scanner.nextLine()
                .replaceAll("\\s+", "");
        return line.equalsIgnoreCase("end")
                ? null
                : line;
    }
}
