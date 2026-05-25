package comp;

import engine.ExpressionVisitor;

public class Division extends BinaryOperator {
    public Division(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double accept(ExpressionVisitor visitor) {
        return visitor.visit(this);
    }
}