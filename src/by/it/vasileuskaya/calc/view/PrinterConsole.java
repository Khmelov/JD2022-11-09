package by.it.vasileuskaya.calc.view;

import by.it.vasileuskaya.calc.exception.CalcException;
import by.it.vasileuskaya.calc.model.Var;

public class PrinterConsole implements Printer {

    @Override
    public void print(Var var) {
        System.out.println(var);
    }

    @Override
    public void showCalcException(CalcException e) {
        System.out.println(e.getMessage());
    }
}

