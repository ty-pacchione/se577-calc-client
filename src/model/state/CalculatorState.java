package model.state;

public interface CalculatorState {
    void handleNumber(CalculatorContext context, String number);

    void handleOperator(CalculatorContext context, String operator);

    void handleEquals(CalculatorContext context);

    void handleClear(CalculatorContext context);
}