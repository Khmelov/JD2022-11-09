package by.it.han.jd02_04;

import by.it._classwork_.calc.exception.CalcException;
import by.it._classwork_.calc.repository.VarRepo;
import by.it._classwork_.calc.service.Parser;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TaskATest {
    private static final double DELTA = 0.001;
    private Parser parser;

    @Before
    public void setUp() {
        parser = new Parser(new VarRepo());
    }

    @Test(timeout = 5000)
    public void calcA() throws CalcException {
        String expression = "A=2+5.3";
        double actual = Double.parseDouble(parser.calc(expression).toString());
        double expected = 7.3;
        assertEquals(actual, expected, DELTA);
    }

    @Test(timeout = 5000)
    public void calcB() throws CalcException {
        String expression = "B=A*3.5";
        double actual = Double.parseDouble(parser.calc(expression).toString());
        double excepted = 25.55;
        assertEquals(excepted, actual, DELTA);
    }

    @Test(timeout = 5000)
    public void calcB1() throws CalcException {
        String expression = "B1=B+0.11*-5";
        double actual = Double.parseDouble(parser.calc(expression).toString());
        double expected = 25;
        assertEquals(actual, expected, DELTA);
    }

    @Test(timeout = 5000)
    public void calcB2() throws CalcException {
        String expression = "B2=A/2-1";
        double actual = Double.parseDouble(parser.calc(expression).toString());
        double excepted = 2.65;
        assertEquals(excepted, actual, DELTA);
    }

}
