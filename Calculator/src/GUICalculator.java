import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class GUICalculator {

    private JFrame frame;
    private JTextField display;
    private JPanel buttonPanel;

    private final Color backgroundColor = new Color(30, 30, 30);
    private final Color buttonColor = new Color(50, 50, 50);
    private final Color textColor = Color.WHITE;
    private final Color accentColor = new Color(139, 0, 0);
    private final Font displayFont = new Font("Roboto", Font.BOLD, 36);
    private final Font buttonFont = new Font("Roboto", Font.PLAIN, 20);

    private String operator = "";
    private double num1 = 0;
    private boolean isOperatorClicked = false;
    private ArrayList<String> history = new ArrayList<>();

    public GUICalculator() {
        frame = new JFrame("Calculator | Assignment 4");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());

        display = createDisplayField();
        buttonPanel = createButtonPanel();

        frame.add(display, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.getContentPane().setBackground(backgroundColor);
        frame.setVisible(true);
    }

    private JTextField createDisplayField() {
        JTextField displayField = new JTextField("0");
        displayField.setHorizontalAlignment(JTextField.RIGHT);
        displayField.setEditable(false);
        displayField.setFont(displayFont);
        displayField.setBackground(backgroundColor);
        displayField.setForeground(textColor);
        displayField.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        return displayField;
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 10, 10));
        panel.setBackground(backgroundColor);

        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "C", "0", "=", "+",
                "History"
        };

        for (String label : buttonLabels) {
            JButton button = createButton(label);
            panel.add(button);
        }
        return panel;
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(buttonFont);
        button.setForeground(textColor);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setContentAreaFilled(false);

        if ("/".equals(text) || "*".equals(text) || "-".equals(text) || "+".equals(text) || "=".equals(text)) {
            button.setForeground(accentColor);
        } else if ("History".equals(text)) {
            button.setForeground(accentColor);
            button.addActionListener(e -> showHistoryFrame());
        }

        button.addActionListener(new ButtonClickListener());
        return button;
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = ((JButton) e.getSource()).getText();

            try {
                if ("0123456789".contains(command)) {
                    // Replace "0" or clear the display when a number is entered
                    if (display.getText().equals("0") || isOperatorClicked) {
                        display.setText(command);
                    } else {
                        display.setText(display.getText() + command);
                    }
                    isOperatorClicked = false;
                } else if ("C".equals(command)) { // Clear button clicked
                    display.setText(""); // Reset to an empty string
                    num1 = 0;
                    operator = "";
                    isOperatorClicked = false;
                } else if ("/".equals(command) || "*".equals(command) || "-".equals(command) || "+".equals(command)) {
                    if (!isOperatorClicked) {
                        num1 = Double.parseDouble(display.getText());
                        operator = command;
                        isOperatorClicked = true;
                    }
                } else if ("=".equals(command)) { // Equals button clicked
                    if (operator.isEmpty() || isOperatorClicked) return;

                    double num2 = Double.parseDouble(display.getText());
                    double result = 0;

                    switch (operator) {
                        case "/":
                            if (num2 == 0) throw new ArithmeticException("Cannot divide by zero.");
                            result = num1 / num2;
                            break;
                        case "*":
                            result = num1 * num2;
                            break;
                        case "-":
                            result = num1 - num2;
                            break;
                        case "+":
                            result = num1 + num2;
                            break;
                    }

                    // Display only the result
                    display.setText(String.valueOf(result));
                    history.add(num1 + " " + operator + " " + num2 + " = " + result);
                    saveHistoryToFile();
                    isOperatorClicked = true;
                }
            } catch (ArithmeticException ex) {
                display.setText("Error");
            } catch (NumberFormatException ex) {
                display.setText("Invalid Input");
            }
        }
    }


    private void showHistoryFrame() {
        JFrame historyFrame = new JFrame("History");
        historyFrame.setSize(300, 400);
        historyFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        historyFrame.getContentPane().setBackground(backgroundColor);
        historyFrame.setLayout(new BorderLayout());

        JTextArea historyArea = new JTextArea();
        historyArea.setEditable(false);
        historyArea.setFont(new Font("Roboto", Font.PLAIN, 16));
        historyArea.setBackground(backgroundColor);
        historyArea.setForeground(textColor);

        loadHistoryFromFile();
        for (String entry : history) {
            historyArea.append(entry + "\n");
        }

        JScrollPane scrollPane = new JScrollPane(historyArea);
        historyFrame.add(scrollPane, BorderLayout.CENTER);

        JButton clearButton = new JButton("Clear History");
        clearButton.setForeground(textColor);
        clearButton.setBackground(accentColor);
        clearButton.setFont(buttonFont);
        clearButton.addActionListener(e -> {
            history.clear();
            saveHistoryToFile();
            historyArea.setText("");
        });

        historyFrame.add(clearButton, BorderLayout.SOUTH);
        historyFrame.setVisible(true);
    }

    private void saveHistoryToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("history.txt"))) {
            for (String entry : history) {
                writer.write(entry);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving history: " + e.getMessage());
        }
    }

    private void loadHistoryFromFile() {
        history.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader("history.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                history.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error loading history: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GUICalculator::new);
    }
}
