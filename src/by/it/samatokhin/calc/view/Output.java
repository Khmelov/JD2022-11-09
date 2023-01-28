package by.it.samatokhin.calc.view;

import by.it.samatokhin.calc.entity.Var;
import by.it.samatokhin.calc.exception.CalcException;

public interface Output {
    void showResult(Var var);

    void showCalcException(CalcException e);
}
