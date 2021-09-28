import composedFunctions.PiecewiseFunction;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Sin function integration")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SinIntegration {
    final double PRECISION = 0.00001;
    final double DELTA = 1e-6;
    PiecewiseFunction piecewiseFunction;

    @BeforeAll
    public void SetUp(){
        piecewiseFunction = new PiecewiseFunction(PRECISION);
        piecewiseFunction.setFuncIsStub(false);
        piecewiseFunction.getLogarithmicFunction().setFuncIsStub(false);
        piecewiseFunction.getTrigonometricFunction().setFuncIsStub(false);
        piecewiseFunction.getTrigonometricFunction().getCsc().setFuncIsStub(false);
        piecewiseFunction.getTrigonometricFunction().getCtg().setFuncIsStub(false);
        piecewiseFunction.getTrigonometricFunction().getCsc().getSin().setFuncIsStub(false);
        piecewiseFunction.getTrigonometricFunction().getCtg().getSin().setFuncIsStub(false);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-2*Math.PI - DELTA, -2*Math.PI, -2*Math.PI + DELTA, -1.5*Math.PI, 
        -Math.PI - DELTA, -Math.PI, -Math.PI + DELTA, -Math.PI/2, 0 - DELTA, 0, 
        0 + DELTA, 0.5, 1 - DELTA, 1, 1 + DELTA, 2, Double.POSITIVE_INFINITY})
    public void testIntegration(double x){
        double expected = piecewiseFunction.getStubValue(x);
        double actual = piecewiseFunction.calculate(x);
        assertEquals(expected, actual, PRECISION);
    }

    @AfterAll
    public void tearDown(){
        try {
            piecewiseFunction.printToFile(-5.0, 0.1, 100, "sin_integration");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
