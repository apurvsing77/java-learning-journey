package Interviews_prep.DesignPrinciple.DRY_Principle.GoodCode;

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

// OrderProcessor.java - DRY Violation Solution
 class OrderProcessor {

    final double DISCOUNT_THRESHOLD = 100.0;
    final double DISCOUNT_PERCENTAGE = 0.10;
    public double calculateDiscountedPriceForBooks(Product book) {
        if (book.getPrice() > DISCOUNT_THRESHOLD) {
            return book.getPrice() * DISCOUNT_PERCENTAGE;
        } else {
            return book.getPrice();
        }
    }

    public double calculateDiscountedPriceForElectronics(Product electronicItem) {
        if (electronicItem.getPrice() > DISCOUNT_THRESHOLD) {
            return electronicItem.getPrice() * DISCOUNT_PERCENTAGE; // 10% छूट
        } else {
            return electronicItem.getPrice();
        }
    }

    public double calculateDiscountedPriceForClothing(Product clothingItem) {
        if (clothingItem.getPrice() > DISCOUNT_THRESHOLD) {
            return clothingItem.getPrice() * DISCOUNT_PERCENTAGE; // 10% छूट
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