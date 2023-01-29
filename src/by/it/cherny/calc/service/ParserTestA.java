package by.it.cherny.calc.service;

import by.it.cherny.calc.exception.CalcException;
import by.it.cherny.calc.repository.VarRepo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTestA {

    private Parser parser;

    @Before
    public void setUp() throws Exception {
        parser = new Parser(new VarRepo());
    }

    @Test(timeout = 5000)
    public void scalarA() throws CalcException {
        String expression = "A=2+5.3";
        double actual = Double.parseDouble(parser.calc(expression).toString());
        double expected = 7.3;
        assertEquals(expected, actual, 1E-5);
    }

    @Test(timeout = 5000)
    public void scalarA1() throws CalcException {
        String expression = "B=A*3.5";
        double actual = Double.parseDouble(parser.calc(expression).toString());
        double expected = 25.55;
        assertEquals(expected, actual, 1E-5);
    }

    @Test(timeout = 5000)
    public void scalarA2() throws CalcException {
        String expression = "B1=B+0.11*-5";
        double actual = Double.parseDouble(parser.calc(expression).toString());
        double expected = 25;
        assertEquals(expected, actual, 1E-5);
    }

    @Test(timeout = 5000)
    public void scalarA3() throws CalcException {
        String expression = "B2=A/2-1";
        double actual = Double.parseDouble(parser.calc(expression).toString());
        double expected = 2.65;
        assertEquals(expected, actual, 1E-5);
    }

    @Test(timeout = 5000)
    public void scalarB() throws CalcException {
        String expression = "C=B+(A*2)";
        double actual = Double.parseDouble(parser.calc(expression).toString());
        double expected = 40.15;
        assertEquals(expected, actual, 1E-5);
    }
//
//    @Test(timeout = 5000)
//    public void scalarB1() throws CalcException {
//        String expression = "D=((C-0.15)-20)/(7-5)";
//        double actual = Double.parseDouble(parser.calc(expression).toString());
//        double expected = 10;
//        assertEquals(expected, actual, 1E-5);
//    }
//
//    @Test(timeout = 5000)
//    public void scalarB2() throws CalcException {
//        String expression = "E={2,3}*(D/2)";
//        String actual = String.valueOf(parser.calc(expression).toString());
//        String expected = "{10,15}";
//        assertEquals(expected, actual, 1E-5);
//    }
}