package state;

import comp.ComputationEngine;
import observer.Observer;
import observer.Subject;

public class CalculatorContext extends Subject implements Observer {
    private String input;
    private CalculatorState state;
    private ComputationEngine engine;

    public CalculatorContext(ComputationEngine engine) {
        input = "";
        state = new EmptyState();
        this.engine = engine;
    }

    private void setInput(String newCalc) {
        input = newCalc;
        notifyObservers(input);
    }
    
    void addInput(String next) {
        setInput(input + next);
    }

    void clearInput() {
        setInput("");
    }

    void setState(CalculatorState newState) {
        state = newState;
    }

    void compute() {
        String calc = input;
        clearInput();
        engine.compute(calc);
    }

    private void handleButton(String button) {
        if (button.matches("[0-9]"))
            state.handleNumber(this, button);
        if (button.matches("[+\\-*/]"))
            state.handleOperator(this, button);
        if (button.equals("="))
            state.handleEquals(this);
        if (button.equals("C"))
            state.handleClear(this);
    }

    @Override
    public void update(String message) {
        handleButton(message);
    }
}