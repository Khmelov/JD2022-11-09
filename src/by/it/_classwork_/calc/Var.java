package by.it._classwork_.calc;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    private static final Map<String, Var> vars = new HashMap<>();

    public static Var create(String stringValue) {
        if (stringValue.matches(Patterns.SCALAR)) {
            return new Scalar(stringValue);
        }
        if (stringValue.matches(Patterns.VECTOR)) {
            return new Vector(stringValue);
        }
        if (stringValue.matches(Patterns.MATRIX)) {
            return new Matrix(stringValue);
        }
        return vars.get(stringValue);
    }

    public static Var save(String name, Var value) {
        vars.put(name, value);
        return value;
    }

    public static void print() {
        for (Map.Entry<String, Var> entry : vars.entrySet()) {
            System.out.printf("%s=%s%n",entry.getKey(),entry.getValue());
        }
    }

    @Override
    public Var add(Var other) {
        System.out.printf("Operation %s + %s is impossible%n", this, other);
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.printf("Operation %s - %s is impossible%n", this, other);
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.printf("Operation %s * %s is impossible%n", this, other);
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.printf("Operation %s / %s is impossible%n", this, other);
        return null;
    }

    @Override
    public String toString() {
        return "unknown variable";
    }

}
