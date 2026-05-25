package main;

import client.CalculatorClient;
import contrl.CalculatorController;
import engine.ComputationEngine;
import state.CalculatorContext;
import state.InputHandler;
import view.CalculatorFrame;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        CalculatorFrame view = new CalculatorFrame();
        InputHandler handler = new InputHandler();
        CalculatorContext context = new CalculatorContext(handler);
        CalculatorController controller = new CalculatorController(context);
        ComputationEngine engine = new ComputationEngine();
        CalculatorClient client = new CalculatorClient();

        view.addObserver(controller);
        handler.addObserver(view);
        context.addObserver(engine);
        engine.addObserver(view);
        engine.addObserver(client);

        view.show();
    }
}