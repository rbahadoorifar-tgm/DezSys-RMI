package calculation;

import java.math.BigDecimal;

/**
 * Small interface for calculations. Edited the return type of the getResult() method. Edited by Jakob Jungreithmeir.
 *
 * @author Michael Borko
 * @version 1.1 24-04-2016
 */
public interface Calculation {

    /**
     * Starts the calculation process.
     * @since 24-04-2016
     */
    void calculate();

    /**
     * Returns the calculated result.
     * @return result of the calculation
     * @since 24-04-2016
     */
    BigDecimal getResult();

}