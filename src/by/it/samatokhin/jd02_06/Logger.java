package by.it.samatokhin.jd02_06;

public class Logger implements Log {
    @Override
    public void error(String message) {
        System.err.println("ERROR");
    }

    @Override
    public void info(String message) {
        System.out.println(message);
    }
}
