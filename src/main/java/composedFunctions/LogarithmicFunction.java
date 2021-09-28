package composedFunctions;

import abstraction.AbstractFunction;
import logarithmic.*;
import util.Functions;

public class LogarithmicFunction extends AbstractFunction {
    public Ln getLn() {
        return ln;
    }

    public Log3 getLog3() {
        return log3;
    }

    public Log2 getLog2() {
        return log2;
    }

    public Log5 getLog5() {
        return log5;
    }

    public Log10 getLog10() {
        return log10;
    }

    Ln ln;
    Log3 log3;
    Log2 log2;
    Log5 log5;
    Log10 log10;

    public LogarithmicFunction(double precision) {
        super(precision);
        this.function = Functions.LOG_FUN;
        super.setFuncIsStub(true);
        ln = new Ln(precision);
        log3 = new Log3(precision);
        log2 = new Log2(precision);
        log5 = new Log5(precision);
        log10 = new Log10(precision);
    }

    @Override
    protected double getFunctionValue(double x) {
        return Math.pow((log2.calculate(x) + log3.calculate(x) * log5.calculate(x) * log10.calculate(x)) / (log5.calculate(x) - ln.calculate(x)), 2);
    }

    @Override
    public double getStubValue(double x) {
        return Math.pow((log2.getStubValue(x) + log3.getStubValue(x) * log5.getStubValue(x) * log10.getStubValue(x)) / (log5.getStubValue(x) - ln.getStubValue(x)), 2);
    }
}
