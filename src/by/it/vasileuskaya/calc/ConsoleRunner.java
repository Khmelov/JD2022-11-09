package by.it.vasileuskaya.calc;

import by.it.vasileuskaya.calc.controller.Input;
import by.it.vasileuskaya.calc.controller.InputConsole;
import by.it.vasileuskaya.calc.exception.CalcException;
import by.it.vasileuskaya.calc.model.Var;
import by.it.vasileuskaya.calc.repository.VarRepository;
import by.it.vasileuskaya.calc.service.Parser;
import by.it.vasileuskaya.calc.view.Printer;
import by.it.vasileuskaya.calc.view.PrinterConsole;

import java.util.Scanner;

public class ConsoleRunner {

    public static final String PRINTVAR = "printvar";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Input input = new InputConsole(scanner);
        Printer output = new PrinterConsole();
        VarRepository varRepo = new VarRepository();
        Parser parser = new Parser(varRepo);
        for (; ; ) {
            String expression = input.getCommand();
            if (expression != null) {
                try {
                    if (!expression.equals(PRINTVAR)) {
                        Var result = parser.calc(expression);
                        output.print(result);
                    } else {
                        varRepo.print();
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