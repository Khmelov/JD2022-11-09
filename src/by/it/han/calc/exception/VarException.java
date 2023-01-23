package by.it.han.calc.exception;

public class VarException extends Exception {
    public VarException(String message) {
        super("ERROR: " + message);
    }
}
