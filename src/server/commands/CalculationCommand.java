package server.commands;

import java.io.Serializable;
import calculation.Calculation;
import callback.Callback;

/**
 * Created by Ramin on 28.04.2016.
 */
public class CalculationCommand implements Command, Serializable {

    private static final long serialVersionUID = 3202369269194172790L;
    private Calculation calculation;
    private Callback callback;

    public CalculationCommand (Calculation calculation, Callback callback) {
        this.calculation = calculation;
        this.callback = callback;
    }

    @Override
    public void execute() {
        System.out.println("CalculationCommand called!");
        calculation.calculate();
        calculation.getResult();
    }
}
