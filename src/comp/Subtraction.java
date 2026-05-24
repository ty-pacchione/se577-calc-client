package comp;

import visitor.ExpressionVisitor;

public class Subtraction extends BinaryOperator {
    public Subtraction(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double accept(ExpressionVisitor visitor) {
        return visitor.visit(this);
    }
}