package by.it.cherny.calc.view;

import by.it.cherny.calc.entity.Var;
import by.it.cherny.calc.exception.CalcException;

public interface Output {
    void showResult(Var var);
    void showCalcException(CalcException e);
    void printVars();
    void printSortedVar();
}
