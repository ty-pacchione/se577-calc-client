package model.state;

public class ClearedState extends NumberState {
    @Override
    public void handleOperator(CalculatorContext context, String input) { }

    @Override
    public void handleEquals(CalculatorContext context) { }
}