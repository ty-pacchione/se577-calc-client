package engine;

import comp.Addition;
import comp.Division;
import comp.Multiplication;
import comp.Number;
import comp.Subtraction;

public class ExpressionEvaluator implements ExpressionVisitor {
    @Override
    public double visit(Number number) {
        return number.getValue();
    }

    @Override
    public double visit(Addition addition) {
        return addition.getLeft().accept(this) + addition.getRight().accept(this);
    }

    @Override
    public double visit(Subtraction subtraction) {
        return subtraction.getLeft().accept(this) - subtraction.getRight().accept(this);
    }

    @Override
    public double visit(Multiplication multiplication) {
        return multiplication.getLeft().accept(this) * multiplication.getRight().accept(this);
    }

    @Override
    public double visit(Division division) {
        return division.getLeft().accept(this) / division.getRight().accept(this);
    }
}