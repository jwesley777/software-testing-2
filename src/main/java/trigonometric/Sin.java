package trigonometric;

import abstraction.AbstractFunction;
import util.Functions;

public class Sin extends AbstractFunction {

    public Sin (double precision){
        super(precision);
        this.function = Functions.SIN;
        super.setFuncIsStub(true);
        cos = new Cosine(precision);
    }
    
    public Cosine getCos() {
        return cos;
    }

    Cosine cos;

    @Override
    protected double getFunctionValue(double x) {
        // calculate a modulus of x
        x = x % (Math.PI * 2);
        if (x < 0) {
            x = x + Math.PI * 2;
        }

        double sign = x <= Math.PI ? 1 : -1;
        double value = Math.sqrt(1 - cos.calculate(x) * cos.calculate(x));
        return sign * value;
    }

    @Override
    protected double getStubValue(double x) {
        return Math.sin(x);
    }
    
}
