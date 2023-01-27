package by.it.han.calc.exception;

import by.it.han.calc.model.Error;
import by.it.han.calc.service.ResMan;

public class VarException extends Exception {
    public VarException(String message, ResMan resMan) {
        super(resMan.get(Error.message) + message);
    }
}
