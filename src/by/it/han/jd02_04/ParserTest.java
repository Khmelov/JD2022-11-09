package by.it.han.jd02_04;

import by.it.han.calc.exception.CalcException;
import by.it.han.calc.service.Parser;
import by.it.han.calc.exception.VarException;
import by.it.han.calc.service.ResMan;
import org.junit.Before;
import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class ParserTest {
    private static final double DELTA = 0.001;
    private Parser parser;
    private final ResMan resMan = ResMan.INSTANCE;

    @Before
    public void upTest() {
        resMan.setLocal(new Locale("ru"));
    }

    @Test(timeout = 5000)
    public void calcA() throws CalcException, VarException {
        parser = new Parser("A=2+5.3", resMan);
        double actual = Double.parseDouble(parser.calc().toString());
        double expected = 7.3;
        assertEquals(actual, expected, DELTA);
    }

    @Test(timeout = 5000)
    public void calcB() throws CalcException, VarException {
        parser = new Parser("B=A*3.5", resMan);
        double actual = Double.parseDouble(parser.calc().toString());
        double excepted = 25.55;
        assertEquals(excepted, actual, DELTA);
    }

    @Test(timeout = 5000)
    public void calcB1() throws CalcException, VarException {
        parser = new Parser("B1=B+0.11*-5", resMan);
        double actual = Double.parseDouble(parser.calc().toString());
        double expected = 25;
        assertEquals(actual, expected, DELTA);
    }

    @Test(timeout = 5000)
    public void calcB2() throws CalcException, VarException {
        parser = new Parser("B2=A/2-1", resMan);
        double actual = Double.parseDouble(parser.calc().toString());
        double excepted = 2.65;
        assertEquals(excepted, actual, DELTA);
    }


}
