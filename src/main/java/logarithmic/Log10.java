package logarithmic;

import util.Functions;

public class Log10 extends BaseLogarithm {
    public Log10(double precision){
        super(precision);
        this.function = Functions.LOG10;
        super.setFuncIsStub(true);
    }
    @Override
    public double getFunctionValue(double x){
        //return super.calculate(3, x);
        return super.getFunctionValue(x)/super.getFunctionValue(10);
    }

    @Override
    public double getStubValue(double x) {
        //return super.stub(3, x);
        return super.getStubValue(x)/super.getStubValue(10);
    }
}