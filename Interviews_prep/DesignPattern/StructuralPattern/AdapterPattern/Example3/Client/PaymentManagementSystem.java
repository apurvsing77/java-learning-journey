package Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example3.Client;

import Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example3.Target.PaymentGateway;

public class PaymentManagementSystem {
    private PaymentGateway paymentGateway;

    public PaymentManagementSystem(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public void processPaymentForCreditCard(String cardNumber, double amount) {

            paymentGateway.processCreditCardPayment(cardNumber, amount);

    }
    public void processPaymentForPayPal(String userEmail, double amount) {

            paymentGateway.processPayPalPayment(userEmail, amount);
    }
}