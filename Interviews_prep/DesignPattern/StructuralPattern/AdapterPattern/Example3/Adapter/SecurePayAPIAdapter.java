package Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example3.Adapter;

import Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example3.Adaptee.SecurePayAPI;
import Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example3.Target.PaymentGateway;

public class SecurePayAPIAdapter implements PaymentGateway {

    private SecurePayAPI securePayAPI ;

    public SecurePayAPIAdapter(SecurePayAPI securePayAPI) {
        this.securePayAPI = securePayAPI;
    }

    @Override
    public void processCreditCardPayment(String cardNumber, double amount) {
        System.out.println("Processing credit card payment of amount: " + amount + " with card number: " + cardNumber);
        securePayAPI.makePayment(cardNumber,amount);
    }

    @Override
    public void processPayPalPayment(String userEmail, double amount) {

        System.out.println("SecurePayAdapter: PayPal payment not supported by SecurePay for user: " + userEmail);


    }
}
