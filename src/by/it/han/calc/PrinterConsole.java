package by.it.han.calc;

import java.util.Map;

public class PrinterConsole implements Printer {

    @Override
    public void print(Var var) {
        System.out.println(var);
    }

    public void printVar(Map<String, Var> map) {
        for (Map.Entry<String, Var> entry : map.entrySet()) {
            System.out.printf("%s=%s%n", entry.getKey(), entry.getValue());
        }
    }
}
