package by.it.bolshakov.calc.entity;


import by.it.bolshakov.calc.exception.CalcException;
import by.it.bolshakov.calc.service.Operation;

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
