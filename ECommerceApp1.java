import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
public class ECommerceApp1 {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Sample products
        products.add(new Product("Laptop", 999.99, 4.5));
        products.add(new Product("Smartphone", 499.49, 4.2));
        products.add(new Product("Headphones", 89.99, 4.0));
        products.add(new Product("Smartwatch", 199.99, 4.3));

        System.out.println("=== Welcome to E-Commerce Application ===");

        boolean running = true;
        while (running) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Show All Products");
            System.out.println("2. Sort by Price (Low to High)");
            System.out.println("3. Sort by Price (High to Low)");
            System.out.println("4. Sort by Rating (High to Low)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayProducts(products);
                    break;
                case 2:
                    Collections.sort(products, Comparator.comparingDouble(Product::getPrice));
                    System.out.println("\nSorted by Price (Low to High):");
                    displayProducts(products);
                    break;
                case 3:
                    Collections.sort(products, Comparator.comparingDouble(Product::getPrice).reversed());
                    System.out.println("\nSorted by Price (High to Low):");
                    displayProducts(products);
                    break;
                case 4:
                    Collections.sort(products, Comparator.comparingDouble(Product::getRating).reversed());
                    System.out.println("\nSorted by Rating (High to Low):");
                    displayProducts(products);
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting the application. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    public static void displayProducts(ArrayList<Product> products) {
        for (Product p : products) {
            p.displayProduct();
        }
    }
}
