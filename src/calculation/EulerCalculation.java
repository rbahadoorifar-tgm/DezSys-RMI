package calculation;

import java.io.Serializable;
import java.math.*;

/**
 * Created by Ramin on 28.04.2016.
 */
public class EulerCalculation implements Calculation, Serializable {

    private int digits;
    private BigDecimal euler;

    public EulerCalculation(int digits) {
        this.digits = digits;
    }

    @Override
    public void calculate() {
        BigDecimal e = BigDecimal.ONE;
        BigDecimal fact = BigDecimal.ONE;

        for(int i=1;i<100;i++) {
            fact = fact.multiply(new BigDecimal(i));

            e = e.add(BigDecimal.ONE.divide(fact, new MathContext(digits, RoundingMode.HALF_UP)));
        }
        this.euler = e;
    }

    @Override
    public BigDecimal getResult() {
        return euler;
    }
}
