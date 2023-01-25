package by.it.bolshakov.calc.view;

import by.it.bolshakov.calc.entity.Var;
import by.it.bolshakov.calc.exception.CalcException;

public interface Output {
    void showResult(Var var);
    void showCalcException(CalcException e);
}
