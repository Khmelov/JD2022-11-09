package by.it.cherny.calc;

public interface Output {
    void showResult(Var var);
    void showCalcException(CalcException e);
    void printVars();
    void printSortedVar();
}
