package callback;

import java.math.BigDecimal;

/**
 * Callback Klasse für alle Kalkulationen. Daher wird ein BigDecimal als Parameter verlangt.
 */
public class CalculationCallback implements Callback<BigDecimal>{

    /**
     * Gibt die output Variable in die Konsole aus.
     *
     * @param output Ergebniss der Kalkulation.
     */
    @Override
    public void execute(BigDecimal output) {
        System.out.println(output);
    }

}