package by.it.cherny.calc.view;

import by.it.cherny.calc.controller.Logger;
import by.it.cherny.calc.entity.Var;
import by.it.cherny.calc.exception.CalcException;
import by.it.cherny.calc.repository.VarRepo;

import java.util.Map;
import java.util.TreeMap;

public class ConsoleOutput implements Output {

    public void logInfo(String message){
        Logger.INSTANCE.info(message);
    }
    @Override
    public void showResult(Var var) {
        logInfo("show result "+ var.toString());
        System.out.println(var);
    }

    @Override
    public void showCalcException(CalcException e) {
        logInfo("show exception "+e.getMessage());
        System.out.println(e.getMessage());
    }

    @Override
    public void printVars() {
        logInfo("printed vars...");
        for (Map.Entry<String, Var> entry : VarRepo.vars.entrySet()) {
            System.out.printf("%s=%s%n", entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void printSortedVar() {
        logInfo("printed sorted vars...");
        Map<String, Var> map = new TreeMap<>(VarRepo.vars);
        map.entrySet().forEach(System.out::println);
    }
}
