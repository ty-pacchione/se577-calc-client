package main;

// import client.CalculatorClient;
import comp.ComputationEngine;
import state.CalculatorContext;
import view.CalculatorFrame;

public class Main {
    public static void main(String[] args) {
        CalculatorFrame view = new CalculatorFrame();
        ComputationEngine engine = new ComputationEngine();
        CalculatorContext context = new CalculatorContext(engine);
        // CalculatorClient client = new CalculatorClient("localhost", 3000);

        view.addObserver(context);
        context.addObserver(view);
        engine.addObserver(view);
        // engine.addObserver(client);

        view.show();
    }
}