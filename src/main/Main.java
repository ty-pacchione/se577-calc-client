package main;

import model.comp.ComputationHandler;
import model.state.CalculatorContext;
import view.CalculatorFrame;

public class Main {
    public static void main(String[] args) {
        ComputationHandler parser = new ComputationHandler();
        CalculatorContext model = new CalculatorContext(parser);
        new CalculatorFrame(model).show();
    }
}