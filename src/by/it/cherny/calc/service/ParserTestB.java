package by.it.cherny.calc.service;

import by.it.cherny.calc.exception.CalcException;
import by.it.cherny.calc.repository.VarRepo;
import by.it.han.jd01_09.Vector;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ParserTestB {
    private Parser parser;

    @Before
    public void setUp() throws Exception {
        parser = new Parser(new VarRepo());
    }

    @Test(timeout = 5000)
    public void scalarA() throws CalcException {
        String expression = "C=B+(A*2)";
        double actual = Double.parseDouble(parser.calc(expression).toString());
        double expected = 40.15;
        assertEquals(expected, actual, 1E-5);
    }

    @Test(timeout = 5000)
    public void scalarB() throws CalcException {
        String expression = "D=((C-0.15)-20)/(7-5)";
        double actual = Double.parseDouble(parser.calc(expression).toString());
        double expected = 10;
        assertEquals(expected, actual, 1E-5);
    }

    @Test(timeout = 5000)
    public void scalarB1() throws CalcException {
        String expression = "E={2,3}*(D/2)";
        String actual = String.valueOf(parser.calc(expression).toString());
        String expected = "{10,15}";
        assertEquals(expected, actual, 1E-5);
    }
}
