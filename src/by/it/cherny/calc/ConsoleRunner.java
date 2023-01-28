package by.it.cherny.calc;

import by.it.cherny.calc.controller.Input;
import by.it.cherny.calc.controller.InputConsole;
import by.it.cherny.calc.entity.Var;
import by.it.cherny.calc.exception.CalcException;
import by.it.cherny.calc.repository.VarRepo;
import by.it.cherny.calc.service.Parser;
import by.it.cherny.calc.view.ConsoleOutput;
import by.it.cherny.calc.view.Output;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Input input = new InputConsole(scanner);
        VarRepo varRepo = new VarRepo();
        Parser parser = new Parser(varRepo);
        Output output = new ConsoleOutput();
        for(;;){
            String expression = input.getCommand();
            if (expression!=null){
                try {
                    if (!expression.equals("printvar")&&!expression.equals("sortvar")){
                        Var result=parser.calc(expression);
                        output.showResult(result);
                    } else if (expression.equals("sortvar")) {
                        output.printSortedVar();
                    } else {
                        output.printVars();
                    }
                } catch (CalcException e){
                    output.showCalcException(e);
                }
            } else {
                break;
            }
        }
    }
}
