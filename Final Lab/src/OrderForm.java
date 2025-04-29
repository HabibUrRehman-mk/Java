import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OrderForm {
    private ArrayList<Product> products; // Product list
    private ArrayList<Order> orders;    // Orders list
    private ArrayList<Product> cartProducts;
    private ArrayList<Integer> cartQuantities;
    private double cartTotal;

    public OrderForm() {
        products = new ArrayList<>();
        orders = new ArrayList<>();
        cartProducts = new ArrayList<>();
        cartQuantities = new ArrayList<>();
        cartTotal = 0;

        // Adding sample products
        products.add(new Product("Laptop", "Electronics", 750));
        products.add(new Product("Headphones", "Accessories", 50));
        products.add(new Product("Book", "Stationery", 15));
        products.add(new Product("Smartphone", "Electronics", 500));

        createGUI();
    }

    private void createGUI() {
        JFrame frame = new JFrame("Order Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 600);

        // Use BoxLayout for the frame to manage panels more efficiently
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        // Product table
        String[] columns = {"Name", "Category", "Price"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
        JTable productTable = new JTable(tableModel);
        for (Product product : products) {
            tableModel.addRow(new Object[]{product.getName(), product.getCategory(), product.getPrice()});
        }
        JScrollPane productScrollPane = new JScrollPane(productTable);

        // Customer details panel
        JPanel customerPanel = new JPanel(new GridLayout(3, 2));
        customerPanel.setBorder(BorderFactory.createTitledBorder("Customer Details"));
        JTextField nameField = new JTextField();
        JTextField contactField = new JTextField();
        JTextField addressField = new JTextField();
        customerPanel.add(new JLabel("Name:"));
        customerPanel.add(nameField);
        customerPanel.add(new JLabel("Contact:"));
        customerPanel.add(contactField);
        customerPanel.add(new JLabel("Address:"));
        customerPanel.add(addressField);

        // Cart display
        DefaultTableModel cartTableModel = new DefaultTableModel(new String[]{"Name", "Category", "Price", "Quantity", "Total", "Action"}, 0);
        JTable cartTable = new JTable(cartTableModel);
        JScrollPane cartScrollPane = new JScrollPane(cartTable);

        JLabel totalPriceLabel = new JLabel("Total Price: $0.00");

        // Buttons
        JButton addButton = new JButton("Add to Cart");
        JButton checkoutButton = new JButton("Checkout");

        // Add components to frame
        frame.add(productScrollPane);
        frame.add(customerPanel);

        JPanel cartPanel = new JPanel(new BorderLayout());
        cartPanel.setBorder(BorderFactory.createTitledBorder("Cart"));
        cartPanel.add(cartScrollPane, BorderLayout.CENTER);
        cartPanel.add(totalPriceLabel, BorderLayout.SOUTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(checkoutButton);
        cartPanel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(cartPanel);

        // Add to Cart action
        addButton.addActionListener(e -> {
            int selectedRow = productTable.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(frame, "Please select a product to add to the cart.");
                return;
            }

            Product selectedProduct = products.get(selectedRow);

            String quantityStr = JOptionPane.showInputDialog(frame, "Enter quantity for " + selectedProduct.getName() + ":");
            if (quantityStr == null || quantityStr.isEmpty()) {
                return;
            }

            try {
                int quantity = Integer.parseInt(quantityStr);
                if (quantity <= 0) {
                    JOptionPane.showMessageDialog(frame, "Quantity must be greater than 0.");
                    return;
                }

                double total = selectedProduct.getPrice() * quantity;
                cartProducts.add(selectedProduct);
                cartQuantities.add(quantity);
                cartTotal += total;

                cartTableModel.addRow(new Object[]{selectedProduct.getName(), selectedProduct.getCategory(), selectedProduct.getPrice(), quantity, total, "Delete"});
                totalPriceLabel.setText("Total Price: $" + String.format("%.2f", cartTotal));

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid quantity. Please enter a valid number.");
            }
        });

        // Checkout action
        checkoutButton.addActionListener(e -> {
            String customerName = nameField.getText().trim();
            String contact = contactField.getText().trim();
            String address = addressField.getText().trim();

            if (customerName.isEmpty() || contact.isEmpty() || address.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill in all customer details.");
                return;
            }

            if (cartProducts.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Your cart is empty.");
                return;
            }

            orders.add(new Order(customerName, contact, address, new ArrayList<>(cartProducts), new ArrayList<>(cartQuantities), cartTotal));

            JOptionPane.showMessageDialog(frame, "Order placed successfully!");
            cartProducts.clear();
            cartQuantities.clear();
            cartTotal = 0;
            cartTableModel.setRowCount(0);
            totalPriceLabel.setText("Total Price: $0.00");
            nameField.setText("");
            contactField.setText("");
            addressField.setText("");
        });

        // Delete action (for Cart)
        cartTable.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());
        cartTable.getColumnModel().getColumn(5).setCellEditor(new ButtonEditor(new JCheckBox(), frame));

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(OrderForm::new);
    }
}

// ButtonRenderer implementation
class ButtonRenderer extends JButton implements TableCellRenderer {
    public ButtonRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setText(value == null ? "" : value.toString());
        return this;
    }
}

// ButtonEditor implementation
class ButtonEditor extends DefaultCellEditor {
    private JButton button;
    private boolean isPushed;

    public ButtonEditor(JCheckBox checkBox, JFrame frame) {
        super(checkBox);
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(e -> fireEditingStopped());
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        button.setText(value == null ? "" : value.toString());
        isPushed = true;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        if (isPushed) {
            int modelRow = ((JTable) getComponent()).getSelectedRow();
            ((DefaultTableModel) ((JTable) getComponent()).getModel()).removeRow(modelRow);
        }
        isPushed = false;
        return "";
    }
}
