package by.it.han.calc;

import java.util.Map;

public interface Printer {
    void print(Var var);

    void printVar(Map<String, Var> map);
}

