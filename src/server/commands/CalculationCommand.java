package server.commands;
import java.io.Serializable;
import calculation.Calculation;

/**
 * Führt die gegebene Kalkulation aus.
 */
public class CalculationCommand implements Command, Serializable {

    private static final long serialVersionUID = 3202369269194172790L;
    private Calculation calculation;

    public CalculationCommand (Calculation calculation) {
        this.calculation = calculation;
    }

    /**
     * Führt die Kalkulation aus.
     */
    @Override
    public void execute() {
        System.out.println("CalculationCommand called!");
        calculation.calculate();
    }
}
