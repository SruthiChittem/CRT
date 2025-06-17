import java.util.ArrayList;
import java.util.Scanner;

// Class to represent a product
class Product {
    private String name;
    private double price;
    private double rating;

    public Product(String name, double price, double rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }

    public void displayProduct() {
        System.out.println("Product Name: " + name);
        System.out.println("Price: $" + price);
        System.out.println("Rating: " + rating + " stars");
        System.out.println("----------------------------------");
    }
}

// Main application
public class ECommerceApp {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Welcome to E-Commerce Application ===");

        // Add products manually or from user input
        products.add(new Product("Laptop", 999.99, 4.5));
        products.add(new Product("Smartphone", 499.49, 4.2));
        products.add(new Product("Headphones", 89.99, 4.0));

        // Display all products
        System.out.println("\n--- Available Products ---");
        for (Product p : products) {
            p.displayProduct();
        }

        scanner.close();
    }
}
