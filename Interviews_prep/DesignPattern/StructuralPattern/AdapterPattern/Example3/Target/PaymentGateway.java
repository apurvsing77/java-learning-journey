package Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example3.Target;

public interface PaymentGateway {
    void processCreditCardPayment(String cardNumber, double amount);
    void processPayPalPayment(String userEmail, double amount);
}