package by.it.bolshakov.jd02_04;

import by.it.bolshakov.calc.exception.CalcException;
import by.it.bolshakov.calc.repository.VarRepo;
import by.it.bolshakov.calc.service.Parser;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTestA {

    private Parser parser;

    @Before
    public void setUp() {
        parser = new Parser(new VarRepo());
    }

    @Test
    public void scalarA() throws CalcException {
        String expression = "A=2+5.3";
        double actual = Double.parseDouble(parser.calc(expression).toString());
        double expected = 7.3;
        assertEquals(expected, actual, 1E-5);
    }

    @Test
    public void scalarB() throws CalcException {
        String expression = "B=A*3.5";
        double actual = Double.parseDouble(parser.calc(expression).toString());
        double expected = 25.55;
        assertEquals(expected, actual, 1E-5);
    }

    @Test
    public void scalarB1() throws CalcException {
        String expression = "B1=B+0.11*-5";
        double actual = Double.parseDouble(parser.calc(expression).toString());
        double expected = 25;
        assertEquals(expected, actual, 1E-5);
    }

    @Test
    public void scalarB2() throws CalcException {
        String expression = "B2=A/2-1";
        double actual = Double.parseDouble(parser.calc(expression).toString());
        double expected = 2.65;
        assertEquals(expected, actual, 1E-5);
    }
}