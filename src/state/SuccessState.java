package state;

public class SuccessState extends CalculatorState {
    @Override
    public void handleOperator(CalculatorContext context, String input) {
        context.clearInput();
        context.setState(new EmptyState());
    }

    @Override
    public void handleEquals(CalculatorContext context) {
        context.clearInput();
        context.setState(new EmptyState());
    }
}