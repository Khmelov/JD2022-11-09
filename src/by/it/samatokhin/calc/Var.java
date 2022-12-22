package by.it.samatokhin.calc;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    private static final Map<String, Var> vars = new HashMap<>();

    public static Var create(String varName) throws CalcException {
        if (varName.matches(Patterns.SCALAR)) {
            return new Scalar(varName);
        }
        if (varName.matches(Patterns.VECTOR)) {
            return new Vector(varName);
        }
        if (varName.matches(Patterns.MATRIX)) {
            return new Matrix(varName);
        }
        Var var = vars.get(varName);
        if (var == null) {
            throw new CalcException("Variable %s not found".formatted(varName));
        }
        return var;
    }

    public static Var save(String name, Var value) {
        vars.put(name, value);
        return value;
    }

    public static void print() {

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

    @Override
    public String toString() {
        return "Это класс Var";
    }
}
