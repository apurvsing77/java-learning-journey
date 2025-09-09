package Interviews_prep.DesignPattern.PracricExample.AdapterMeathed.paymentProcess.target;

public interface PaymentProcessor {
    void processPayment(double amount);
    boolean verifyTransaction(String transactionId);

}
