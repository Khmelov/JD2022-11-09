package by.it.vasileuskaya.jd01_09;

public class PrinterConsole implements Printer {

    @Override
    public void print(Var var) {
        System.out.println(var);
    }
}
