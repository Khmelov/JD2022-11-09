package by.it.bolshakov.calc.service;

import by.it.bolshakov.calc.entity.Var;
import by.it.bolshakov.calc.exception.CalcException;

public interface Operation {
    Var add(Var other) throws CalcException;

    Var sub(Var other) throws CalcException;

    Var mul(Var other) throws CalcException;

    Var div(Var other) throws CalcException;
}