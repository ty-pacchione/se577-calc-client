package comp;

import observer.Subject;
import visitor.ExpressionEvaluator;

public class ComputationEngine extends Subject {
    public void compute(String calculation) {
        Expression expr = parseExpression(calculation);
        double result = expr.accept(new ExpressionEvaluator());
        String resultText = String.format("%.5f", result);
        notifyObservers(calculation + "=" + resultText);
    }

    private Expression parseExpression(String calc) {
        if (calc.matches(".+\\+.+"))
            return parseAddition(calc);
        if (calc.matches(".+-.+"))
            return parseSubtraction(calc);
        if (calc.matches(".+\\*.+"))
            return parseMultiplication(calc);
        if (calc.matches(".+/.+"))
            return parseDivision(calc);
        if (calc.matches("[0-9]+"))
            return parseNumber(calc);
        throw new IllegalArgumentException();
    }

    private Addition parseAddition(String calc) {
        int index = calc.indexOf("+");
        String left = calc.substring(0, index);
        String right = calc.substring(index + 1);
        return new Addition(parseExpression(left), parseExpression(right));
    }

    private Subtraction parseSubtraction(String calc) {
        int index = calc.lastIndexOf("-");
        String left = calc.substring(0, index);
        String right = calc.substring(index + 1);
        return new Subtraction(parseExpression(left), parseExpression(right));
    }

    private Multiplication parseMultiplication(String calc) {
        int index = calc.indexOf("*");
        String left = calc.substring(0, index);
        String right = calc.substring(index + 1);
        return new Multiplication(parseExpression(left), parseExpression(right));
    }

    private Division parseDivision(String calc) {
        int index = calc.lastIndexOf("/");
        String left = calc.substring(0, index);
        String right = calc.substring(index + 1);
        return new Division(parseExpression(left), parseExpression(right));
    }

    private Number parseNumber(String calc) {
        return new Number(Integer.parseInt(calc));
    }
}