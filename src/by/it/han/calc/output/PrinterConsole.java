package by.it.han.calc.output;

import by.it.han.calc.model.Var;

import java.util.Map;

public class PrinterConsole implements Printer {

    @Override
    public void print(Var var) {
        System.out.println(var);
    }

    @Override
    public void printVar(Map<String, Var> map) {
        for (Map.Entry<String, Var> entry : map.entrySet()) {
            System.out.printf("%s=%s%n", entry.getKey(), entry.getValue());
        }
    }

    public static void print(Object o) {
        System.out.println(o);
    }
}
