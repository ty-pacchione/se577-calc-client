package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import obsrv.Observer;
import obsrv.Subject;

public class CalculatorFrame extends Subject implements Observer {
    public static final String[][] BUTTONS = {
            { "7", "8", "9", "/" },
            { "4", "5", "6", "*" },
            { "1", "2", "3", "-" },
            { "0", "C", "=", "+" }
    };

    public static final int WIDTH = 400;
    public static final int HEIGHT = 400;
    public static final int TEXT_SIZE = 50;

    private JFrame frame;
    private JTextField displayPanel;

    public CalculatorFrame() {
        makeFrame();
    }

    private void makeFrame() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
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
        displayPanel.setFont(new Font("Monospaced", Font.PLAIN, TEXT_SIZE));

        return displayPanel;
    }

    private JPanel makeButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(BUTTONS.length, BUTTONS[0].length));

        for (String[] row : BUTTONS) {
            for (String buttonText : row) {
                JButton button = new JButton(buttonText);

                button.addActionListener(event -> {
                    notifyObservers(event.getActionCommand());
                });

                buttonPanel.add(button);
            }
        }

        return buttonPanel;
    }

    public void show() {
        frame.setVisible(true);
    }

    @Override
    public void update(String message) {
        displayPanel.setText(getDisplayText(message));
    }

    private String getDisplayText(String text) {
        int index = text.indexOf("=");
        if (index == -1) {
            return text;
        } else {
            return text.substring(index + 1);
        }
    }
}