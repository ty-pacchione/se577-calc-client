package view;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Panel {
    private JFrame frame;

    public Panel(String calculation) {
        frame = new JFrame("Calculator");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel(calculation);
        frame.getContentPane().add(label);
    }

    public void show() {
        frame.pack();
        frame.setVisible(true);
    }
}