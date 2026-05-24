package model.comp;

public class Number implements Expression {
    private int value;

    public Number(int value) {
        this.value = value;
    }

    @Override
    public double evaluate() {
        return value;
    }
}