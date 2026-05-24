package model.comp;

public class Multiplication extends BinaryOperator {
    public Multiplication(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double evaluate() {
        return left.evaluate() * right.evaluate();
    }
}