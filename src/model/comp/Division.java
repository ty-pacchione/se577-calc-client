package model.comp;

public class Division extends BinaryOperator {
    public Division(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double evaluate() {
        return (double) left.evaluate() / right.evaluate();
    }
}