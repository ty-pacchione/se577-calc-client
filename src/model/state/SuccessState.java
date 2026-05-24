package model.state;

public class SuccessState extends NumberState {
    @Override
    public void handleNumber(CalculatorContext context, String input) {
        context.clearInput();
        super.handleNumber(context, input);
    }

    @Override
    public void handleOperator(CalculatorContext context, String input) {
        super.handleClear(context);
    }

    @Override
    public void handleEquals(CalculatorContext context) {
        super.handleClear(context);
    }
}