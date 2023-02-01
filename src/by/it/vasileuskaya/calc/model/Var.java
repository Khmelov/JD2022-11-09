package by.it.vasileuskaya.calc.model;

import by.it.vasileuskaya.calc.exception.CalcException;
import by.it.vasileuskaya.calc.service.Operation;

public abstract class Var implements Operation {

    @Override
    public String toString() {
        return "unknown variable";
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(String.format("Operation %s + %s is impossible%n", this, other));
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(String.format("Operation %s - %s is impossible%n", this, other));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(String.format("Operation %s * %s is impossible%n", this, other));
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(String.format("Operation %s / %s is impossible%n", this, other));
    }
}
