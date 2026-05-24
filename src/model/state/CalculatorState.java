package model.state;

public class CalculatorState {
    public void handleNumber(CalculatorContext context, String number) {
        context.addInput(number);
        context.setState(new CalculatorState());
    }

    public void handleOperator(CalculatorContext context, String operator) {
        context.addInput(operator);
        context.setState(new ClearedState());
    }

    public void handleEquals(CalculatorContext context) {
        context.setInput(context.compute());
        context.setState(new SuccessState());
    }

    public void handleClear(CalculatorContext context) {
        context.clearInput();
        context.setState(new ClearedState());
    }
}