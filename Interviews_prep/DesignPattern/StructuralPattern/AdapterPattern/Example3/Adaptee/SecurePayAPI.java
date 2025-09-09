package Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example3.Adaptee;

public class SecurePayAPI {
    public void makePayment(String creditCardNumber, double transactionAmount) {
        System.out.println("SecurePay: Processing credit card payment: " + creditCardNumber + " for " + transactionAmount);
        // ... internal SecurePay logic
    }
    // SecurePay does NOT support PayPal directly through this API
}