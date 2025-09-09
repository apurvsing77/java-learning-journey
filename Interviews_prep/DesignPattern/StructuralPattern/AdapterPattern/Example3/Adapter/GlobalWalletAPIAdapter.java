package Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example3.Adapter;

import Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example3.Adaptee.GlobalWalletAPI;
import Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example3.Target.PaymentGateway;

public class GlobalWalletAPIAdapter implements PaymentGateway {

    private GlobalWalletAPI globalWalletAPI;

    public GlobalWalletAPIAdapter(GlobalWalletAPI globalWalletAPI) {
        this.globalWalletAPI = globalWalletAPI;
    }

    @Override
    public void processCreditCardPayment(String cardNumber, double amount) {
        System.out.println("Processing credit card payment of amount: " + amount + " with card number: " + cardNumber);
        globalWalletAPI.performTransaction(cardNumber, amount, "Credit Card");
    }

    @Override
    public void processPayPalPayment(String userEmail, double amount) {

        System.out.println("Processing PayPal payment of amount: " + amount + " with user email: " + userEmail);
        globalWalletAPI.performTransaction(userEmail, amount, "PayPal");
    }
}
