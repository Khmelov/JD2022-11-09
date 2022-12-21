package by.it.vasileuskaya.calc;

public class OutputConsole implements Output {

    @Override
    public void showResult(Var var) {
        System.out.println(var);
    }
}
