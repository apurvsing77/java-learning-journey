package Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example3.Adaptee;

public class GlobalWalletAPI {
    public void performTransaction(String accountId, double totalAmount, String paymentMethod) {
        System.out.println("GlobalWallet: Performing transaction for account " + accountId +
                " with " + paymentMethod + " for " + totalAmount);
        // ... internal GlobalWallet logic
    }
    // paymentMethod can be "CREDIT_CARD" or "PAYPAL"
}