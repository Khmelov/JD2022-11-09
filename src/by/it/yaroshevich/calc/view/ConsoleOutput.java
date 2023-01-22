package by.it.yaroshevich.calc.view;

import by.it.yaroshevich.calc.entity.Var;
import by.it.yaroshevich.calc.exception.CalcException;

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
