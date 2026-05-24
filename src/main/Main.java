package main;

import model.comp.ComputationHandler;
import model.state.CalculationHandler;
import model.state.CalculatorContext;
import model.visitor.ExpressionEvaluator;
import model.visitor.ExpressionVisitor;
import view.CalculatorFrame;

public class Main {
    public static void main(String[] args) {
        CalculatorFrame view = new CalculatorFrame();

        CalculationHandler handler = new CalculationHandler();
        CalculatorContext context = new CalculatorContext(handler);

        ExpressionVisitor visitor = new ExpressionEvaluator();
        ComputationHandler computer = new ComputationHandler(visitor);

        view.addObserver(context);
        handler.addObserver(view);
        context.addObserver(computer);
        computer.addObserver(view);

        view.show();
    }
}