package by.it.han.calc.model;

import by.it.han.calc.util.Patterns;
import by.it.han.calc.exception.VarException;

import java.util.HashMap;
import java.util.Map;

public class Var implements Operation {

    private static final Map<String, Var> map = new HashMap<>();

    public static Var create(String strValue) throws VarException {
        if (strValue.matches(Patterns.SCALAR)) {
            return new Scalar(strValue);
        } else if (strValue.matches(Patterns.VECTOR)) {
            return new Vector(strValue);
        } else if (strValue.matches(Patterns.MATRIX)) {
            return new Matrix(strValue);
        } else if (map.containsKey(strValue)) {
            return map.get(strValue);
        }
        throw new VarException("Невозможно создать переменную");
    }

    public Map<String, Var> getMap() {
        return map;
    }

    public static Var saveVar(String name, Var var) {
        map.put(name, var);
        return var;
    }

    public static void sortMap() {
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "unknown variable";
    }
}
