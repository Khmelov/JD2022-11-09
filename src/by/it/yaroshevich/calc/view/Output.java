package by.it.yaroshevich.calc.view;

import by.it.yaroshevich.calc.entity.Var;
import by.it.yaroshevich.calc.exception.CalcException;

public interface Output {
    void showResult(Var var);
    void showCalcException(CalcException e);
}
