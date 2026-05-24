package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import observer.Observer;
import observer.Subject;

public class CalculatorFrame extends Subject implements Observer {
    public static final String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
    };

    private JFrame frame;
    private JTextField displayPanel;

    public CalculatorFrame() {
        makeFrame();
    }

    private void makeFrame() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLayout(new BorderLayout());

        displayPanel = makeDisplayPanel();
        frame.add(displayPanel, BorderLayout.NORTH);

        JPanel buttonPanel = makeButtonPanel();
        frame.add(buttonPanel, BorderLayout.CENTER);
    }

    private JTextField makeDisplayPanel() {
        JTextField displayPanel = new JTextField();

        displayPanel.setEditable(false);
        displayPanel.setHorizontalAlignment(JTextField.RIGHT);
        displayPanel.setFont(new Font("Monospaced", Font.PLAIN, 60));

        return displayPanel;
    }

    private JPanel makeButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 10, 10));

        for (String text : buttons) {
            JButton button = new JButton(text);

            button.addActionListener(event -> {
                notifyObservers(event.getActionCommand());
            });

            buttonPanel.add(button);
        }

        return buttonPanel;
    }

    public void show() {
        frame.setVisible(true);
    }

    @Override
    public void update(String message) {
        int index = message.indexOf("=");
        if (index == -1) {
            displayPanel.setText(message);
        } else {
            displayPanel.setText(message.substring(index + 1));
        }
    }
}