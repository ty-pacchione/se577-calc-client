package visitor;

import comp.Addition;
import comp.Division;
import comp.Multiplication;
import comp.Number;
import comp.Subtraction;

public interface ExpressionVisitor {
    double visit(Number number);

    double visit(Addition addition);
    
    double visit(Subtraction subtraction);

    double visit(Multiplication multiplication);

    double visit(Division division);
}