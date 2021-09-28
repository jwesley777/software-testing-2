package trigonometric;

import abstraction.AbstractFunction;
import util.Functions;

public class Cotangent extends AbstractFunction {
    public Cotangent(double precision) {
        super(precision);
        this.function = Functions.CTG;
        super.setFuncIsStub(true);
        cos = new Cosine(precision);
        sin = new Sin(precision);
    }

    public Sin getSin() {
        return sin;
    }

    public Cosine getCos() {
        return cos;
    }

    Cosine cos;
    Sin sin;

    @Override
    public double getFunctionValue(double x) {
        // x = x % Math.PI;
        // if (x == Math.PI) {
        //     return Double.NEGATIVE_INFINITY;
        // }
        // if (x == 0.0) {
        //     return Double.POSITIVE_INFINITY;
        // }
        // double sin = x, cos = 1, cotan = 0, a = 1;
        // int n = 2;
        // while (Math.abs(cos / sin - cotan) > precision) {
        //     cotan = cos / sin;
        //     a *= -x * x / ((n - 1) * n);
        //     cos += a;
        //     sin += a * x / (n + 1);
        //     n += 2;
        // }
        double cotan = cos.calculate(x) / sin.calculate(x);
        return Double.isFinite(cotan) ? cotan : Double.NaN;
    }

    @Override
    public double getStubValue(double x) {
        //System.out.println(x%Math.PI);
        // if ( Math.abs(x%Math.PI) == Math.PI) {
        //     return Double.NEGATIVE_INFINITY;
        // }
        // if (Math.abs(x%Math.PI) == 0.0) {
        //     return Double.POSITIVE_INFINITY;
        // } else
        double cotan = 1. / Math.tan(x);
        return Double.isFinite(cotan) ? cotan : Double.NaN;
    }

}
