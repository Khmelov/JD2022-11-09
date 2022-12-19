package by.it.cherny.calc;

public class ConsoleOutput implements Output {
    @Override
    public void showResult(Var var) {
        System.out.println(var);
    }
}
