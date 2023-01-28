package by.it.samatokhin.calc.entity;

import by.it.samatokhin.calc.exception.CalcException;
import by.it.samatokhin.calc.service.Operation;

public abstract class Var implements Operation {

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

    @Override
    public String toString() {
        return "unknown variable";
    }

}
