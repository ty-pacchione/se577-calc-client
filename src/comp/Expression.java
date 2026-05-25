package comp;

import engine.ExpressionVisitor;

public interface Expression {
    double accept(ExpressionVisitor visitor);
}