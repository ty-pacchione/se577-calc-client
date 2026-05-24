package model.state;

public abstract class CalculatorState {
    public void handleNumber(CalculatorContext context, String number) {
        context.addToCalculation(number);
        context.setState(new NumberState());
    }

    public void handleOperator(CalculatorContext context, String operator) {
        context.addToCalculation(operator);
        context.setState(new OperatorState());
    }

    public void handleEquals(CalculatorContext context) {
        context.compute();
        context.setState(new SuccessState());
    }

    public void handleClear(CalculatorContext context) {
        context.clearCalculation();
        context.setState(new EmptyState());
    }
}