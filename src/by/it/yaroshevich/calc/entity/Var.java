package by.it.yaroshevich.calc.entity;

import by.it.yaroshevich.calc.service.Operation;
import by.it.yaroshevich.calc.exception.CalcException;
import by.it.yaroshevich.calc.util.Patterns;

public abstract class Var implements Operation {

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(String.format("Operation %s + %s is impossible%n", this, other));
    }

    @Override
    public Var sub(Var other)  throws CalcException {
        throw new CalcException(String.format("Operation %s - %s is impossible%n", this, other));
    }

    @Override
    public Var mul(Var other)  throws CalcException {
        throw new CalcException(String.format("Operation %s * %s is impossible%n", this, other));
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(String.format("Operation %s / %s is impossible%n", this, other));
    }

    @Override
    public String toString() {
        return "unknown variable";
    }

}