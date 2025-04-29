import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ProductGUI {
    private Product productManager; // Use the updated Product class with ProductManager functionality

    public ProductGUI() {
        productManager = new Product(); // Initialize Product class
        createGUI();
    }

    public void createGUI() {
        // Create the main frame
        JFrame frame = new JFrame("Product Management");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 500);

        // Components for adding a product
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(15);
        JLabel categoryLabel = new JLabel("Category:");
        JTextField categoryField = new JTextField(15);
        JLabel priceLabel = new JLabel("Price:");
        JTextField priceField = new JTextField(15);
        JButton addButton = new JButton("Add Product");
        JButton displayButton = new JButton("Display Products");
        JTextArea displayArea = new JTextArea(15, 35);
        displayArea.setEditable(false);

        // ActionListener for "Add Product" button
        addButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            String category = categoryField.getText().trim();
            String priceText = priceField.getText().trim();

            if (name.isEmpty() || category.isEmpty() || priceText.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill out all fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                double price = Double.parseDouble(priceText);
                productManager.addProduct(name, category, price);
                JOptionPane.showMessageDialog(frame, "Product added successfully!");
                nameField.setText("");
                categoryField.setText("");
                priceField.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid price. Please enter a numeric value.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // ActionListener for "Display Products" button
        displayButton.addActionListener(e -> {
            String products = productManager.displayProducts();
            displayArea.setText(products);
        });

        // Layout setup
        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(categoryLabel);
        inputPanel.add(categoryField);
        inputPanel.add(priceLabel);
        inputPanel.add(priceField);
        inputPanel.add(addButton);
        inputPanel.add(displayButton);

        JPanel displayPanel = new JPanel(new FlowLayout());
        displayPanel.add(new JScrollPane(displayArea));

        // Add panels to the frame
        frame.setLayout(new BorderLayout());
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(displayPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ProductGUI::new);
    }
}
