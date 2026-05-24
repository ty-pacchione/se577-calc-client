package model.state;

public class SuccessState extends CalculatorState {
    @Override
    public void handleOperator(CalculatorContext context, String input) {
        context.clearCalculation();
        context.setState(new EmptyState());
    }

    @Override
    public void handleEquals(CalculatorContext context) {
        context.clearCalculation();
        context.setState(new EmptyState());
    }
}