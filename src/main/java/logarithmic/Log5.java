package logarithmic;

import util.Functions;

public class Log5 extends BaseLogarithm {
    public Log5(double precision){
        super(precision);
        this.function = Functions.LOG5;
        super.setFuncIsStub(true);
    }
    @Override
    public double getFunctionValue(double x){
        //return super.calculate(3, x);
        return super.getFunctionValue(x)/super.getFunctionValue(5);
    }

    @Override
    public double getStubValue(double x) {
        //return super.stub(3, x);
        return super.getStubValue(x)/super.getStubValue(5);
    }
}