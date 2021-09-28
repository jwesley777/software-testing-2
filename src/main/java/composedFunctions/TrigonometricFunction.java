package composedFunctions;

import abstraction.AbstractFunction;
import trigonometric.Cosecant;
import trigonometric.Cosine;
import trigonometric.Cotangent;
import trigonometric.Sin;
import util.Functions;

public class TrigonometricFunction extends AbstractFunction {
    public Cotangent getCtg() {
        return ctg;
    }
    Cotangent ctg;

    public Cosine getCos() {
        return cos;
    }
    Cosine cos;

    public Sin getSin() {
        return sin;
    }
    Sin sin;

    public Cosecant getCsc() {
        return csc;
    }
    Cosecant csc;

    public TrigonometricFunction (double precision){
        super(precision);
        this.function = Functions.TRIG_FUN;
        super.setFuncIsStub(true);
        ctg = new Cotangent(precision);
        cos = new Cosine(precision);
        sin = new Sin(precision);
        csc = new Cosecant(precision);
    }

    @Override
    protected double getFunctionValue(double x){
        return (cos.calculate(x) - cos.calculate(x)) / (csc.calculate(x) - ctg.calculate(x));
    }

    @Override
    public double getStubValue(double x) {
        return (cos.getStubValue(x) - cos.getStubValue(x)) / (csc.getStubValue(x) - ctg.getStubValue(x));
    }
}
