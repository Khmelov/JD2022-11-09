package by.it.samatokhin.calc.view;

import by.it.samatokhin.calc.entity.Var;
import by.it.samatokhin.calc.exception.CalcException;

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
