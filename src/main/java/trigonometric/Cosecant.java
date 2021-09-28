package trigonometric;

import abstraction.AbstractFunction;
import util.Functions;

public class Cosecant extends AbstractFunction {
    public Cosecant (double precision){
        super(precision);
        this.function = Functions.COSEC;
        super.setFuncIsStub(true);
        sin = new Sin(precision);
    }
    
    public Sin getSin() {
        return sin;
    }

    Sin sin;

    @Override
    protected double getFunctionValue(double x) {
        // x = x % Math.PI;
        double sinValue = sin.calculate(x);

        double csc = 1. / sinValue;
        
        return Double.isFinite(csc) ? csc : Double.NaN;
    }

    @Override
    public double getStubValue(double x) {
        double csc = 1. / Math.sin(x);
        return Double.isFinite(csc) ? csc : Double.NaN;
    }
    
}
