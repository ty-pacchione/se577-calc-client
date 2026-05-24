package comp;

import visitor.ExpressionVisitor;

public class Number implements Expression {
    private int value;

    public Number(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public double accept(ExpressionVisitor visitor) {
        return visitor.visit(this);
    }
}