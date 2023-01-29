package by.it.vasileuskaya.jd01_09;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Input input = new InputConsole(scanner);
        Parser parser = new Parser();
        Printer output = new PrinterConsole();
        for (; ; ) {
            String expression = input.getCommand();
            if (expression != null) {
                Var result = parser.calc(expression);
                output.print(result);
            } else {
                break;
            }
        }

    }
}
