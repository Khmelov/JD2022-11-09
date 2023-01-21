package by.it.cherny.calc.service;

import by.it.cherny.calc.entity.Var;
import by.it.cherny.calc.exception.CalcException;

public interface Operation {
    Var add(Var other) throws CalcException;
    Var sub(Var other) throws CalcException;
    Var mul(Var other) throws CalcException;
    Var div(Var other) throws CalcException;
}
