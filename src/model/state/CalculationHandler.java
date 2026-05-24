package model.state;

import model.observer.Subject;

public class CalculationHandler extends Subject {
    String calculation;

    public CalculationHandler() {
        calculation = "";
    }

    public String getCalculation() {
        return calculation;
    }

    private void setCalculation(String newCalc) {
        calculation = newCalc;
        notifyObservers(calculation);
    }
    
    public void addToCalculation(String next) {
        setCalculation(calculation + next);
    }

    public void clearCalculation() {
        setCalculation("");
    }
}