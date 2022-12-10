package by.it.han.jd01_09;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Input inputConsole = new InputConsole(scanner);
        Printer printerConsole = new PrinterConsole();
        while (true) {
            String expression = inputConsole.input();
            if (expression == null) {
                break;
            }
            Parser parser = new Parser(expression);
            Var result = parser.calc();
            printerConsole.print(result);
        }
    }
}
