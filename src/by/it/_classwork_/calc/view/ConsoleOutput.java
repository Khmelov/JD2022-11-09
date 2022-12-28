package by.it._classwork_.calc.view;

import by.it._classwork_.calc.entity.Var;
import by.it._classwork_.calc.exception.CalcException;

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
