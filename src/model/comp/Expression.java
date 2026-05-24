package model.comp;

import model.visitor.ExpressionVisitor;

public interface Expression {
    double accept(ExpressionVisitor visitor);
}