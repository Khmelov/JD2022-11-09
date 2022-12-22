package by.it.cherny.calc;

import java.util.Map;
import java.util.TreeMap;

public class ConsoleOutput implements Output {
    @Override
    public void showResult(Var var) {
        System.out.println(var);
    }

    @Override
    public void printVars() {
        for (Map.Entry<String, Var> entry : Var.vars.entrySet()) {
            System.out.printf("%s=%s%n", entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void printSortedVar() {
        Map<String, Var> map = new TreeMap<>(Var.vars);
        map.entrySet().forEach(System.out::println);
    }
}
