package model.state;

import model.comp.ComputationHandler;

public class CalculatorContext {
    private String input;
    private CalculatorState state;
    private ComputationHandler parser;

    public CalculatorContext(ComputationHandler parser) {
        input = "";
        state = new ClearedState();
        this.parser = parser;
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

    public String getInput() {
        return input;
    }

    public void setInput(String newInput) {
        input = newInput;
    }
    
    public void addInput(String next) {
        input += next;
    }

    public void clearInput() {
        input = "";
    }

    public void setState(CalculatorState newState) {
        state = newState;
    }

    public String compute() {
        return parser.compute(input);
    }
}