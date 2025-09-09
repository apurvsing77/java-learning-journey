package Interviews_prep.DesignPattern.PracricExample.AdapterMeathed.paymentProcess.client;

import Interviews_prep.DesignPattern.PracricExample.AdapterMeathed.paymentProcess.target.PaymentProcessor;

public class CarSalesSystem {
    private PaymentProcessor currentPaymentProcessor;

    public CarSalesSystem(PaymentProcessor paymentProcessor) {
        this.currentPaymentProcessor = paymentProcessor;
        System.out.println("Payment processor set to: " + paymentProcessor.getClass().getSimpleName());

    }

    public void sellCar(String customerName, double price, String transactionRef) {

        System.out.println("\nSelling car to " + customerName + " for " + price + " Rs");
        currentPaymentProcessor.processPayment(price);
        boolean verified = currentPaymentProcessor.verifyTransaction(transactionRef);
        if (verified ) {
            System.out.println("Transaction " + transactionRef + " successfully verified. Car sale complete!");
        } else {
            System.out.println("Transaction " + transactionRef + " verification failed. Car sale pending!");
        }
    }

}
