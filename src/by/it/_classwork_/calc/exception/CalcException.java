package by.it._classwork_.calc.exception;

@SuppressWarnings("unused")
public class CalcException extends Exception {
    public CalcException() {
        super("ERROR: no message");
    }

    public CalcException(String message) {
        super("ERROR: " + message);
    }

    public CalcException(String message, Throwable cause) {
        super("ERROR: " + message, cause);
    }

    public CalcException(Throwable cause) {
        super("ERROR: no message", cause);
    }
}
