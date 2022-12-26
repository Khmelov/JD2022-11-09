package by.it.vasileuskaya.calc;

public class CalcException extends Exception {
    public CalcException() {
        super("Error: no message");
    }

    public CalcException(String message) {
        super("Error: " + message);
    }

    public CalcException(String message, Throwable cause) {
        super("Error: " + message, cause);
    }

    public CalcException(Throwable cause) {
        super("Error: no message", cause);
    }
}
