package model.visitor;

import model.comp.Addition;
import model.comp.Division;
import model.comp.Multiplication;
import model.comp.Number;
import model.comp.Subtraction;

public interface ExpressionVisitor {
    double visit(Number number);

    double visit(Addition addition);
    
    double visit(Subtraction subtraction);

    double visit(Multiplication multiplication);

    double visit(Division division);
}