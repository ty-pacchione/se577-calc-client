package model.state;

import model.observer.Observer;
import model.observer.Subject;

public class CalculatorContext extends Subject implements Observer {
    private CalculatorState state;
    private CalculationHandler handler;

    public CalculatorContext(CalculationHandler handler) {
        this.handler = handler;
        state = new EmptyState();
    }
    
    public void addToCalculation(String next) {
        handler.addToCalculation(next);
    }

    public void clearCalculation() {
        handler.clearCalculation();
    }

    public void setState(CalculatorState newState) {
        state = newState;
    }

    public void compute() {
        String calculation = handler.getCalculation();
        clearCalculation();
        notifyObservers(calculation);
    }

    public void handleInput(String input) {
        if (input.matches("[0-9]"))
            state.handleNumber(this, input);
        if (input.matches("[+\\-*/]"))
            state.handleOperator(this, input);
        if (input.equals("="))
            state.handleEquals(this);
        if (input.equals("C"))
            state.handleClear(this);
    }

    @Override
    public void update(String message) {
        handleInput(message);
    }
}