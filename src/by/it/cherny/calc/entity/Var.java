package by.it.cherny.calc.entity;

import by.it.cherny.calc.service.Operation;
import by.it.cherny.calc.exception.CalcException;
import by.it.cherny.calc.util.Patterns;

import java.util.HashMap;
import java.util.Map;

public abstract class Var implements Operation {

    @Override
    public String toString() {
        return "unknown variable (abstract stub)";
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(String.format("Operation %s + %s is imposible\n", this, other));
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(String.format("Operation %s - %s is imposible\n", this, other));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(String.format("Operation %s * %s is imposible\n", this, other));
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(String.format("Operation %s / %s is imposible\n", this, other));
    }
}
