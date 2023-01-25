package by.it.yaroshevich.calc;

import by.it.yaroshevich.calc.controller.Input;
import by.it.yaroshevich.calc.controller.InputConsole;
import by.it.yaroshevich.calc.entity.Var;
import by.it.yaroshevich.calc.exception.CalcException;
import by.it.yaroshevich.calc.repository.VarRepo;
import by.it.yaroshevich.calc.service.Parser;
import by.it.yaroshevich.calc.view.ConsoleOutput;
import by.it.yaroshevich.calc.view.Output;
import java.util.Scanner;

public class ConsoleRunner {

    public static final String PRINTVAR = "printvar";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Input input = new InputConsole(scanner);
        VarRepo varRepo = new VarRepo();
        Parser parser = new Parser(varRepo);
        Output output = new ConsoleOutput();
        for (; ; ) {
            String expression = input.getCommand();
            if (expression != null) {
                try {
                    if (!expression.equals(PRINTVAR)) {
                        Var result = parser.calc(expression);
                        output.showResult(result);
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
