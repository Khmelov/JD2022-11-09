package by.it.han.calc.output;

import by.it.han.calc.model.Var;

import java.util.Map;

public interface Printer {
    void print(Var var);


    void printVar(Map<String, Var> map);
}

