package engine;

import java.text.DecimalFormat;

import comp.Addition;
import comp.Division;
import comp.Expression;
import comp.Multiplication;
import comp.Number;
import comp.Subtraction;
import obsrv.Observer;
import obsrv.Subject;

public class ComputationEngine extends Subject implements Observer {
    private static DecimalFormat df = new DecimalFormat("#.#####");

    private void compute(String calculation) {
        Expression expr = parseExpression(calculation);
        ExpressionEvaluator eval = new ExpressionEvaluator();
        double result = expr.accept(eval);
        String resultText = df.format(result);
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

    @Override
    public void update(String message) {
        compute(message);
    }
}