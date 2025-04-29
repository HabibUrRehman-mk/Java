import java.util.ArrayList;

class Order {
    private String customerName;
    private String contactNumber;
    private String address;
    private ArrayList<Product> products;
    private ArrayList<Integer> quantities;
    private double totalPrice;

    public Order(String customerName, String contactNumber, String address, ArrayList<Product> products, ArrayList<Integer> quantities, double totalPrice) {
        this.customerName = customerName;
        this.contactNumber = contactNumber;
        this.address = address;
        this.products = products;
        this.quantities = quantities;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Customer: " + customerName + ", Contact: " + contactNumber + ", Address: " + address + ", Total: $" + totalPrice;
    }
}