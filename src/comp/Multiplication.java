package comp;

import engine.ExpressionVisitor;

public class Multiplication extends BinaryOperator {
    public Multiplication(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double accept(ExpressionVisitor visitor) {
        return visitor.visit(this);
    }
}