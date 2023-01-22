package by.it.yaroshevich.calc.controller;

import by.it.yaroshevich.calc.controller.Input;

import java.util.Scanner;

public class InputConsole implements Input {
    private final Scanner scanner;
    public InputConsole(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String getCommand() {
        String line = scanner.nextLine();
        line = line.replaceAll("\\s+", "");
        return line.equalsIgnoreCase("end")
                ? null // TODO change with Optional
                : line;
    }
}
