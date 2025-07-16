package Interviews_prep.DesignPrinciple.DRY_Principle.BadCode;

// Product.java
public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

// OrderProcessor.java - DRY Violation
 class OrderProcessor {

    public double calculateDiscountedPriceForBooks(Product book) {
        if (book.getPrice() > 100) {
            return book.getPrice() * 0.90;
        } else {
            return book.getPrice();
        }
    }

    public double calculateDiscountedPriceForElectronics(Product electronicItem) {
        if (electronicItem.getPrice() > 100) {
            return electronicItem.getPrice() * 0.90;
        } else {
            return electronicItem.getPrice();
        }
    }

    public double calculateDiscountedPriceForClothing(Product clothingItem) {
        if (clothingItem.getPrice() > 100) {
            return clothingItem.getPrice() * 0.90;
        } else {
            return clothingItem.getPrice();
        }
    }

    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();
        Product book1 = new Product("Java Programming", 120.0);
        Product laptop = new Product("Dell XPS", 1500.0);
        Product shirt = new Product("T-Shirt", 80.0);

        System.out.println("Book discounted price: " + processor.calculateDiscountedPriceForBooks(book1));
        System.out.println("Laptop discounted price: " + processor.calculateDiscountedPriceForElectronics(laptop));
        System.out.println("Shirt discounted price: " + processor.calculateDiscountedPriceForClothing(shirt));

    }
}