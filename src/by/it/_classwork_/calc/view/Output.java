package by.it._classwork_.calc.view;

import by.it._classwork_.calc.entity.Var;
import by.it._classwork_.calc.exception.CalcException;

public interface Output {
    void showResult(Var var);
    void showCalcException(CalcException e);
}
