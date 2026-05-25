package state;

public abstract class CalculatorState {
    public void handleDigit(CalculatorContext context, String number) {
        context.addInput(number);
        context.setState(new DigitState());
    }

    public void handleOperator(CalculatorContext context, String operator) {
        context.addInput(operator);
        context.setState(new OperatorState());
    }

    public void handleEquals(CalculatorContext context) {
        context.computeInput();
        context.setState(new CompletedState());
    }

    public void handleClear(CalculatorContext context) {
        context.clearInput();
        context.setState(new EmptyState());
    }
}