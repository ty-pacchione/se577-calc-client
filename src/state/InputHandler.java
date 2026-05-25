package state;

import obsrv.Subject;

public class InputHandler extends Subject {
    private String input;

    public InputHandler() {
        input = "";
    }

    String getInput() {
        return input;
    }

    private void setInput(String newInput) {
        input = newInput;
        notifyObservers(input);
    }
    
    public void addInput(String nextInput) {
        setInput(input + nextInput);
    }

    public void clearInput() {
        setInput("");
    }
}