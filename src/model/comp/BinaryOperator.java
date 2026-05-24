package model.comp;

public abstract class BinaryOperator implements Expression {
    protected Expression left;
    protected Expression right;

    public BinaryOperator(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }
}