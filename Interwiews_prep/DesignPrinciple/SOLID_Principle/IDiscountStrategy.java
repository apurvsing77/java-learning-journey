package Interwiews_prep.DesignPrinciple.SOLID_Principle;// OCP Refactoring: Open for Extension, Closed for Modification

// --- Discount Strategies ---
// Base interface for all discount types (OCP & LSP)
interface IDiscountStrategy {
    double applyDiscount(double originalAmount);
}

// Concrete implementations for different discount types
class StandardDiscount implements IDiscountStrategy {
    @Override
    public double applyDiscount(double originalAmount) {
        System.out.println("Applying standard 10% discount.");
        return originalAmount * 0.9;
    }
}

class EidSpecialDiscount implements IDiscountStrategy {
    @Override
    public double applyDiscount(double originalAmount) {
        System.out.println("Applying Eid special 15% discount.");
        return originalAmount * 0.85;
    }
}

// New discount type can be added without modifying DiscountService or other existing code
class NewUserDiscount implements IDiscountStrategy {
    @Override
    public double applyDiscount(double originalAmount) {
        System.out.println("Applying new user 20% discount.");
        return originalAmount * 0.80;
    }
}

// --- Payment Processors ---
// Base interface for all payment methods (OCP & LSP)
