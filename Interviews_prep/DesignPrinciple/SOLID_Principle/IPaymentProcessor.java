package Interviews_prep.DesignPrinciple.SOLID_Principle;

interface IPaymentProcessor {
    boolean processPayment(double amount);
}

// Concrete implementations for different payment methods
class CreditCardProcessor implements IPaymentProcessor {
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing Credit Card payment: " + amount);
        // Simulate processing time
        try { Thread.sleep(500); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        return true;
    }
}

class PayPalProcessor implements IPaymentProcessor {
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing PayPal payment: " + amount);
        // Simulate processing time
        try { Thread.sleep(500); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        return true;
    }
}

// New payment method can be added without modifying PaymentService or other existing code
class GooglePayProcessor implements IPaymentProcessor {
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing Google Pay payment: " + amount);
        // Simulate processing time
        try { Thread.sleep(500); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        return true;
    }
}