package calculation;

import callback.Callback;

import java.io.Serializable;
import java.math.*;
import java.rmi.RemoteException;

/**
 * Berechnet die Euler Nummer.
 */
public class EulerCalculation implements Calculation, Serializable {

    //Anzahl der Nachkommastellen
    private int digits;
    private Callback callback;

    public EulerCalculation(int digits, Callback callback) {
        this.digits = digits;
        this.callback = callback;
    }

    /**
     * Berechnet die Euler Zahl und übergibt diese dann dem Callback, welcher wiederrum die Zahl ausgibt.
     */
    @Override
    public void calculate() {
        BigDecimal euler = BigDecimal.ONE;
        BigDecimal fact = BigDecimal.ONE;

        for(int i=1;i<digits;i++) {
            fact = fact.multiply(new BigDecimal(i));

            //Berechnung der Euler-Zahl
            euler = euler.add(BigDecimal.ONE.divide(fact, new MathContext(digits, RoundingMode.HALF_UP)));
        }
        try {
            //Übergabe des Ergebnisses an dem Callback
            callback.execute(euler);
        } catch(RemoteException e) {
            e.printStackTrace();
        }
    }
}
