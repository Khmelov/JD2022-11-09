package by.it.bolshakov.calc;

import by.it.bolshakov.calc.controller.Input;
import by.it.bolshakov.calc.controller.InputConsole;
import by.it.bolshakov.calc.entity.Var;
import by.it.bolshakov.calc.exception.CalcException;
import by.it.bolshakov.calc.repository.VarRepo;
import by.it.bolshakov.calc.service.Parser;
import by.it.bolshakov.calc.view.ConsoleOutput;
import by.it.bolshakov.calc.view.Output;

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
                        varRepo.print(); //TODO move to output
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
