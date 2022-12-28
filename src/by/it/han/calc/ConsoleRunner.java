package by.it.han.calc;

import java.util.Map;
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
            if (expression.equalsIgnoreCase("sortvar")) {
                Var.sortMap();
                continue;
            }
            Parser parser = new Parser(expression);
            Var result = parser.calc();
            if (result != null) {
                printerConsole.print(result);
            }

            Map<String, Var> map = result.getMap();
            if (map != null) {
                printerConsole.printVar(result.getMap());
            }
        }
    }
}
