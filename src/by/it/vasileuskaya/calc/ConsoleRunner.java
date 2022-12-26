package by.it.vasileuskaya.calc;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Input input = new InputConsole(scanner);
        Parser parser = new Parser();
        Output output = new OutputConsole();
        for (; ; ) {
            String expression = input.getCommand();
            if (expression != null) {
                try {
                    if (!expression.equals("printvar")) {
                        Var result = parser.calc(expression);
                        output.showResult(result);
                    } else {
                        Var.print();
                    }
                } catch (CalcException e) {
                    output.showCalcException(e);
                }

            } else {
                break;
            }
        }
    }
}
