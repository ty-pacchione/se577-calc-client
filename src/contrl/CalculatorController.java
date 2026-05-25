package contrl;

import obsrv.Observer;
import state.CalculatorContext;

public class CalculatorController implements Observer {
    private CalculatorContext context;

    public CalculatorController(CalculatorContext context) {
        this.context = context;
    }

    private void handleInput(String input) {
        if (input.matches("[0-9]"))
            context.inputDigit(input);
        if (input.matches("[+\\-*/]"))
            context.inputOperator(input);
        if (input.equals("="))
            context.inputEquals();
        if (input.equals("C"))
            context.inputClear();
    }

    @Override
    public void update(String message) {
        handleInput(message);
    }
}