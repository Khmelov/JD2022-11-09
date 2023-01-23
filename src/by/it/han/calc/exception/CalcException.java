package by.it.han.calc.exception;

import by.it.han.calc.model.Error;
import by.it.han.calc.service.ResMan;

public class CalcException extends Exception {
    public CalcException(ResMan resMan) {
        super(resMan.get(Error.noMessage));
    }

    public CalcException(String message, ResMan resMan) {
        super(resMan.get(Error.message) + message);
    }
}
