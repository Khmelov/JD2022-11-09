package by.it.han.calc;

import java.util.HashMap;
import java.util.Map;

public class Var implements Operation {

    private static Map<String, Var> map = new HashMap<>();

    public static Var create(String strValue) {
        if (strValue.matches(Patterns.SCALAR)) {
            return new Scalar(strValue);
        } else if (strValue.matches(Patterns.VECTOR)) {
            return new Vector(strValue);
        } else if (strValue.matches(Patterns.MATRIX)) {
            return new Matrix(strValue);
        } else if (map.containsKey(strValue)) {
            return map.get(strValue);
        }
        return null;
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
