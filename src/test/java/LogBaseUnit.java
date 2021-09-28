import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import logarithmic.*;

@DisplayName("Log base function unit tests")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LogBaseUnit {
    final double PRECISION = 1e-6;

    Ln ln;
    Log3 log3;
    Log2 log2;
    Log5 log5;
    Log10 log10;
    final double DELTA = 1e-6;

    @BeforeAll
    public void SetUp(){
        ln = new Ln(PRECISION);
        log2 = new Log2(PRECISION);
        log10 = new Log10(PRECISION);
        log5 = new Log5(PRECISION);
        log3 = new Log3(PRECISION);

        ln.setFuncIsStub(false);
        log2.setFuncIsStub(false);
        log3.setFuncIsStub(false);
        log5.setFuncIsStub(false);
        log10.setFuncIsStub(false);
        log2.getLn().setFuncIsStub(false);
        log3.getLn().setFuncIsStub(false);
        log5.getLn().setFuncIsStub(false);
        log10.getLn().setFuncIsStub(false);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0 + DELTA, 0.5, 1 - DELTA, 1, 1 + DELTA, 2, Double.POSITIVE_INFINITY})
    public void testLn(double x){
        double expected = ln.getStubValue(x);
        double actual = ln.calculate(x);
        assertEquals(expected, actual, PRECISION);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0 + DELTA, 0.5, 1 - DELTA, 1, 1 + DELTA, 2, Double.POSITIVE_INFINITY})
    public void testLog2(double x){
        double expected = log2.getStubValue(x);
        double actual = log2.calculate(x);
        assertEquals(expected, actual, PRECISION);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0 + DELTA, 0.5, 1 - DELTA, 1, 1 + DELTA, 2, Double.POSITIVE_INFINITY})
    public void testLog3(double x){
        double expected = log3.getStubValue(x);
        double actual = log3.calculate(x);
        assertEquals(expected, actual, PRECISION);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0 + DELTA, 0.5, 1 - DELTA, 1, 1 + DELTA, 2, Double.POSITIVE_INFINITY})
    public void testLog5(double x){
        double expected = log5.getStubValue(x);
        double actual = log5.calculate(x);
        assertEquals(expected, actual, PRECISION);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0 + DELTA, 0.5, 1 - DELTA, 1, 1 + DELTA, 2, Double.POSITIVE_INFINITY})
    public void testLog10(double x){
        double expected = log10.getStubValue(x);
        double actual = log10.calculate(x);
        assertEquals(expected, actual, PRECISION);
    }    
}
