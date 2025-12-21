package Interviews_prep.DesignPattern.CreationalPattern.FactoryPattern.PaymentExample.product;

import Interviews_prep.DesignPattern.CreationalPattern.FactoryPattern.PaymentExample.PaymentProcessor;

public class PayPalProcessor implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {

        System.out.println("This is PaypalProcesser and amount is : "+amount);
    }
}
