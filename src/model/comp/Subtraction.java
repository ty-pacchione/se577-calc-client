package model.comp;

public class Subtraction extends BinaryOperator {
    public Subtraction(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double evaluate() {
        return left.evaluate() - right.evaluate();
    }
}