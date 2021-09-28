package trigonometric;

import abstraction.AbstractFunction;
import util.Functions;

import static java.lang.Math.PI;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Cosine extends AbstractFunction {
    public final static int SCALE = 1000;
    public final static int MAX_ITERATIONS = 100000;

    public Cosine(double precision) {
        super(precision);
        this.function = Functions.COS;
        super.setFuncIsStub(true);
    }

    @Override
    public double getFunctionValue(double x) {
        if (Double.isNaN(x) || Double.isInfinite(x)) {
            return Double.NaN;
        }

        if (x < -PI || x > PI) {
            x -= ((long) (x / (2 * PI)) + ((x > 0) ? 1 : -1)) * 2 * PI;
        }

        BigDecimal currentValue = new BigDecimal(0, MathContext.UNLIMITED);
        BigDecimal previousValue;
        int iteration = 0;

        do {
            previousValue = currentValue;
            currentValue = currentValue.add((new BigDecimal(-1, MathContext.UNLIMITED).pow(iteration)).
                    multiply((new BigDecimal(x, MathContext.UNLIMITED).pow(2 * iteration))).
                    divide(new BigDecimal(calculateFactorial(2 * iteration)), SCALE, RoundingMode.HALF_UP));
            iteration++;
        } while (getPrecision() <= currentValue.subtract(previousValue).abs().doubleValue() && iteration < MAX_ITERATIONS);

        return currentValue.setScale(SCALE, RoundingMode.UP).doubleValue();
    }

    public double calculateFactorial(int n) {
        double result = 1;

        for (int i = 1; i <= n; i++) {
            result *= i;
        }

        return result;
    }

    @Override
    public double getStubValue(double x) {
        //System.out.println(x%Math.PI);
        return Math.cos(x);
    }

}
