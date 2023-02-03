package by.it.vasileuskaya.calc.service;

import by.it.vasileuskaya.calc.exception.CalcException;
import by.it.vasileuskaya.calc.model.Var;

public interface Operation {
    Var add(Var other) throws CalcException;

    Var sub(Var other) throws CalcException;

    Var mul(Var other) throws CalcException;

    Var div(Var other) throws CalcException;
}