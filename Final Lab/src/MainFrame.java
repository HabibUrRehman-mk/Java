//import javax.swing.*;
//import java.awt.*;
//
//public class MainFrame {
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            // Create the main frame
//            JFrame frame = new JFrame("Product Management System");
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            frame.setSize(400, 300);
//            frame.setLayout(new GridLayout(2, 1, 10, 10));
//
//            // Create buttons for actions
//            JButton addProductButton = new JButton("Add Product");
//            JButton viewProductsButton = new JButton("View Products");
//
//            // Add product button action
//            addProductButton.addActionListener(e -> {
//                // Open a dialog to add a product
//                JTextField nameField = new JTextField();
//                JTextField categoryField = new JTextField();
//                JTextField priceField = new JTextField();
//
//                Object[] message = {
//                        "Product Name:", nameField,
//                        "Category:", categoryField,
//                        "Price:", priceField
//                };
//
//                int option = JOptionPane.showConfirmDialog(null, message, "Add Product", JOptionPane.OK_CANCEL_OPTION);
//                if (option == JOptionPane.OK_OPTION) {
//                    try {
//                        String name = nameField.getText();
//                        String category = categoryField.getText();
//                        double price = Double.parseDouble(priceField.getText());
//
//                        // Add product to the list
//                        Product.addProduct(name, category, price);
//                        JOptionPane.showMessageDialog(null, "Product added successfully!");
//                    } catch (NumberFormatException ex) {
//                        JOptionPane.showMessageDialog(null, "Invalid price. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
//                    }
//                }
//            });
//
//            // View products button action
//            viewProductsButton.addActionListener(e -> {
//                // Display all products
//                String productList = Product.displayProducts();
//                JTextArea textArea = new JTextArea(productList);
//                textArea.setEditable(false);
//
//                JScrollPane scrollPane = new JScrollPane(textArea);
//                scrollPane.setPreferredSize(new Dimension(300, 200));
//
//                JOptionPane.showMessageDialog(null, scrollPane, "Product List", JOptionPane.INFORMATION_MESSAGE);
//            });
//
//            // Add buttons to the frame
//            frame.add(addProductButton);
//            frame.add(viewProductsButton);
//
//            // Center the frame and make it visible
//            frame.setLocationRelativeTo(null);
//            frame.setVisible(true);
//        });
//    }
//}


import javax.swing.*;
import java.awt.*;

public class MainFrame {
    public MainFrame() {
        createMainGUI();
    }

    private void createMainGUI() {
        // Create the main frame
        JFrame frame = new JFrame("Main Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Buttons for different modules
        JButton productManagementButton = new JButton("Product Management");
        JButton orderFormButton = new JButton("Order Form");

        // Panel to hold buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1, 10, 10));
        panel.add(productManagementButton);
        panel.add(orderFormButton);

        // Action for Product Management button
        productManagementButton.addActionListener(e -> {
            SwingUtilities.invokeLater(ProductGUI::new); // Open Product Management GUI
        });

        // Action for Order Form button
        orderFormButton.addActionListener(e -> {
            SwingUtilities.invokeLater(OrderForm::new); // Open Order Form GUI
        });

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}
