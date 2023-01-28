package by.it.han.calc.model;

import by.it.han.calc.exception.VarException;

public interface Operation {

    default Var add(Var other) {
        System.out.printf("Operation %s + %s is impossible%n", this, other);
        return null;
    }

    default Var sub(Var other) {
        System.out.printf("Operation %s - %s is impossible%n", this, other);
        return null;
    }

    default Var mul(Var other) {
        System.out.printf("Operation %s * %s is impossible%n", this, other);
        return null;
    }

    default Var div(Var other) throws VarException {
        System.out.printf("Operation %s / %s is impossible%n", this, other);
        return null;
    }
}
