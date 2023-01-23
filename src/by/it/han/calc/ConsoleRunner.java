package by.it.han.calc;

import by.it.han.calc.exception.CalcException;
import by.it.han.calc.exception.VarException;
import by.it.han.calc.input.Input;
import by.it.han.calc.input.InputConsole;
import by.it.han.calc.model.Var;
import by.it.han.calc.output.Printer;
import by.it.han.calc.output.PrinterConsole;
import by.it.han.calc.service.Parser;

import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) throws CalcException, VarException {
        Scanner scanner = new Scanner(System.in);
        Input inputConsole = new InputConsole(scanner);
        Printer printerConsole = new PrinterConsole();
        while (true) {
            String expression = inputConsole.input();
            if (expression == null) {
                break;
            }
            if (expression.equalsIgnoreCase("sortVar")) {
                Var.sortMap();
                continue;
            }
            Parser parser = new Parser(expression);
            Var result = parser.calc();
            if (result != null) {
                printerConsole.print(result);
            }

            Map<String, Var> map = Objects.requireNonNull(result).getMap();
            if (map != null) {
                printerConsole.printVar(result.getMap());
            }
        }
    }
}
