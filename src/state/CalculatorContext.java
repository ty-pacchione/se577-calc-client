package state;

import obsrv.Subject;

public class CalculatorContext extends Subject {
    private CalculatorState state;
    private InputHandler handler;

    public CalculatorContext(InputHandler handler) {
        state = new EmptyState();
        this.handler = handler;
    }

    public void inputDigit(String number) {
        state.handleDigit(this, number);
    }

    public void inputOperator(String operator) {
        state.handleOperator(this, operator);
    }

    public void inputEquals() {
        state.handleEquals(this);
    }

    public void inputClear() {
        state.handleClear(this);
    }

    void setState(CalculatorState newState) {
        state = newState;
    }

    void addInput(String nextInput) {
        handler.addInput(nextInput);
    }

    void clearInput() {
        handler.clearInput();
    }

    void computeInput() {
        String input = handler.getInput();
        handler.clearInput();
        notifyObservers(input);
    }
}