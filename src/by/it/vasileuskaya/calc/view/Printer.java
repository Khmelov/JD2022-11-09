package by.it.vasileuskaya.calc.view;

import by.it.vasileuskaya.calc.exception.CalcException;
import by.it.vasileuskaya.calc.model.Var;

public interface Printer {
    public void print(Var var);

    public void showCalcException(CalcException e);
}

