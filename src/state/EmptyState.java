package state;

public class EmptyState extends CalculatorState {
    @Override
    public void handleOperator(CalculatorContext context, String input) { }

    @Override
    public void handleEquals(CalculatorContext context) { }
}