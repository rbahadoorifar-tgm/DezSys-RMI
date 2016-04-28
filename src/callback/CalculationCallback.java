package callback;

import java.math.BigDecimal;

/**
 * Created by Ramin on 28.04.2016.
 */
public class CalculationCallback implements Callback<BigDecimal>{

    @Override
    public void execute(BigDecimal output) {
        System.out.println(output);
    }
}
