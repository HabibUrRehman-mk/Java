import java.util.ArrayList;

public class Product {
    private String name;
    private String category;
    private double price;

    // Static list to hold all products
    private static ArrayList<Product> productList = new ArrayList<>();

    // Default constructor
    public Product() {
    }

    // Parameterized constructor
    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Add a product to the list
    public static void addProduct(String name, String category, double price) {
        Product product = new Product(name, category, price);
        productList.add(product);
        System.out.println("Product added: " + product);
    }

    // Display all products
    public static String displayProducts() {
        if (productList.isEmpty()) {
            return "No products available.";
        }

        StringBuilder result = new StringBuilder("Product List:\n");
        for (Product product : productList) {
            result.append(product.toString()).append("\n");
        }
        return result.toString();
    }

    // Override toString for better representation
    @Override
    public String toString() {
        return "Name: " + name + ", Category: " + category + ", Price: $" + price;
    }

    // Static method to get all products
    public static ArrayList<Product> getProductList() {
        return productList;
    }
}

