package by.it.bolshakov.calc.view;


import by.it.bolshakov.calc.entity.Var;
import by.it.bolshakov.calc.exception.CalcException;

public class ConsoleOutput implements Output {

    @Override
    public void showResult(Var var) {
        System.out.println(var);
    }

    @Override
    public void showCalcException(CalcException e) {
        System.out.println(e.getMessage());
    }
}
