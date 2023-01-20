package by.it.vasileuskaya.calc;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTestA {
    private Parser parser;

    @Before
    public void setUp() throws Exception {
        parser = new Parser();

    }

    @Test(timeout = 5000)
    public void scalarA() throws CalcException {
        String expression = "A=2+5.3";
        double actual = Double.parseDouble(parser.calc(expression).toString());
        double expected = 7.3;
        assertEquals(expected, actual, 1E-5);
    }

    @Test(timeout = 5000)
    public void scalarB() throws CalcException {
        String expression = "B=A*3.5";
        double actual = Double.parseDouble(parser.calc(expression).toString());
        double expected = 25.55;
        assertEquals(expected, actual, 1E-5);
    }

    @Test(timeout = 5000)
    public void scalarB1() throws CalcException {
        String expression1 = "A=2+5.3";
        double actual1 = Double.parseDouble(parser.calc(expression1).toString());
        String expression2 = "B=A*3.5";
        double actual2 = Double.parseDouble(parser.calc(expression2).toString());
        String expression = "B1=B+0.11*-5";
        double actual = Double.parseDouble(parser.calc(expression).toString());
        double expected = 25;
        assertEquals(expected, actual, 1E-5);
    }

    @Test(timeout = 5000)
    public void scalarB2() throws CalcException {
        String expression1 = "A=2+5.3";
        double actual1 = Double.parseDouble(parser.calc(expression1).toString());
        String expression = "B2=A/2-1";
        double actual = Double.parseDouble(parser.calc(expression).toString());
        double expected = 2.65;
        assertEquals(expected, actual, 1E-5);
    }
}