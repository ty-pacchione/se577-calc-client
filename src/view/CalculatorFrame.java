package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.state.CalculatorContext;

public class CalculatorFrame {
    public static final String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
    };

    private CalculatorContext context;
    private JFrame frame;

    public CalculatorFrame(CalculatorContext context) {
        this.context = context;
        makeFrame();
    }

    private void makeFrame() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLayout(new BorderLayout());

        JTextField displayPanel = makeDisplayPanel();
        frame.add(displayPanel, BorderLayout.NORTH);

        JPanel buttonPanel = makeButtonPanel(displayPanel);
        frame.add(buttonPanel, BorderLayout.CENTER);
    }

    private JTextField makeDisplayPanel() {
        JTextField displayPanel = new JTextField();

        displayPanel.setEditable(false);
        displayPanel.setHorizontalAlignment(JTextField.RIGHT);
        displayPanel.setFont(new Font("Monospaced", Font.PLAIN, 60));

        return displayPanel;
    }

    private JPanel makeButtonPanel(JTextField displayPanel) {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 10, 10));

        for (String text : buttons) {
            JButton button = new JButton(text);

            button.addActionListener(event -> {
                context.handleInput(event.getActionCommand());
                displayPanel.setText(context.getInput());
            });

            buttonPanel.add(button);
        }

        return buttonPanel;
    }

    public void show() {
        frame.setVisible(true);
    }
}