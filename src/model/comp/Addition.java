package model.comp;

import model.visitor.ExpressionVisitor;

public class Addition extends BinaryOperator {
    public Addition(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double accept(ExpressionVisitor visitor) {
        return visitor.visit(this);
    }
}