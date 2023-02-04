package by.it.cherny.calc.exception;

import by.it.cherny.calc.controller.Logger;

public class CalcException extends Exception {
    public void logError(String message){
        Logger.INSTANCE.error(message);
    }
    public CalcException() {
        super("ERROR: no message");
        logError("no message");
    }

    public CalcException(String message) {
        super("ERROR: "+message);
        logError(message);
    }

    public CalcException(String message, Throwable cause) {
        super("ERROR: "+message, cause);
        logError(message+" "+cause);
    }

    public CalcException(Throwable cause) {
        super("ERROR: no message", cause);
        logError("no message "+cause);
    }
}
