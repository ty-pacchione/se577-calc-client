package model.comp;

import model.observer.Observer;
import model.observer.Subject;
import model.visitor.ExpressionVisitor;

public class ComputationHandler extends Subject implements Observer {
    private ExpressionVisitor visitor;

    public ComputationHandler(ExpressionVisitor visitor) {
        this.visitor = visitor;
    }

    public void compute(String calculation) {
        Expression expression = parse(calculation);
        double result = expression.accept(visitor);
        String resultText = String.format("%.5f", result);
        notifyObservers(calculation + "=" + resultText);
    }

    private Expression parse(String calc) {
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
        return new Addition(parse(left), parse(right));
    }

    private Subtraction parseSubtraction(String calc) {
        int index = calc.lastIndexOf("-");
        String left = calc.substring(0, index);
        String right = calc.substring(index + 1);
        return new Subtraction(parse(left), parse(right));
    }

    private Multiplication parseMultiplication(String calc) {
        int index = calc.indexOf("*");
        String left = calc.substring(0, index);
        String right = calc.substring(index + 1);
        return new Multiplication(parse(left), parse(right));
    }

    private Division parseDivision(String calc) {
        int index = calc.lastIndexOf("/");
        String left = calc.substring(0, index);
        String right = calc.substring(index + 1);
        return new Division(parse(left), parse(right));
    }

    private Number parseNumber(String calc) {
        return new Number(Integer.parseInt(calc));
    }

    @Override
    public void update(String message) {
        compute(message);
    }
}