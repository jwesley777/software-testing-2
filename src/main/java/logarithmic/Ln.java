package logarithmic;
import abstraction.AbstractFunction;
import util.Functions;

import static java.lang.Double.NaN;

public class Ln extends AbstractFunction {
    final int MAX_ITERATIONS = 1000000000;

    public Ln(double precision){
        super(precision);
        this.function = Functions.LN;
        super.setFuncIsStub(true);
    }



    @Override
    public double getFunctionValue(double x){
        double result = 0.0;
        if (x == 0.0)
            return Double.NEGATIVE_INFINITY;
        else if (x < 0.0)
            return NaN;
        if (Double.isInfinite(x)) {
            return Double.POSITIVE_INFINITY;
        }

        double member = 1;
        double numerator;
        double multiplier;
        double coef = 1;

        int i = 0;

        if (x < 1.0){
            numerator = x-1;
            multiplier= -x+1;
            while (Math.abs( member) * 100 > precision && i < MAX_ITERATIONS){
                i++;
                member = numerator/coef;
                //System.out.println(member);
                numerator = numerator*multiplier;
                coef+=1;
                result += member;
            }
        }else{
            numerator = (x-1)/(x+1);
            multiplier = Math.pow((x-1)/(x+1), 2);
            coef = 1;
            while (Math.abs( member) * 100 > precision && i < MAX_ITERATIONS){
                i++;
                member = 2*numerator/coef;
                numerator = numerator*multiplier;
                coef+=2;
                result += member;
            }
        }
        return result;
    }

    @Override
    public double getStubValue(double x) {
        return Math.log(x);
    }

}
