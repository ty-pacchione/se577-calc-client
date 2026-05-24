package comp;

import visitor.ExpressionVisitor;

public interface Expression {
    double accept(ExpressionVisitor visitor);
}