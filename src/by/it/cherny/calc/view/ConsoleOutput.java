package by.it.cherny.calc.view;

import by.it.cherny.calc.entity.Var;
import by.it.cherny.calc.exception.CalcException;
import by.it.cherny.calc.repository.VarRepo;

import java.util.Map;
import java.util.TreeMap;

public class ConsoleOutput implements Output {
    @Override
    public void showResult(Var var) {
        System.out.println(var);
    }

    @Override
    public void showCalcException(CalcException e) {
        System.out.println(e.getMessage());
    }

    @Override
    public void printVars() {
        for (Map.Entry<String, Var> entry : VarRepo.vars.entrySet()) {
            System.out.printf("%s=%s%n", entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void printSortedVar() {
        Map<String, Var> map = new TreeMap<>(VarRepo.vars);
        map.entrySet().forEach(System.out::println);
    }
}
