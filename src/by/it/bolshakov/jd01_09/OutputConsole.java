package by.it.bolshakov.jd01_09;

public class OutputConsole implements Output {

    @Override
    public void showResult(Var var) {
        System.out.println(var);
    }
}
