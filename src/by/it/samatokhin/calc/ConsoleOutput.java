package by.it.samatokhin.calc;

public class ConsoleOutput implements Output {

    @Override
    public void showResult(Var var) {
        System.out.println(var);
    }
}
