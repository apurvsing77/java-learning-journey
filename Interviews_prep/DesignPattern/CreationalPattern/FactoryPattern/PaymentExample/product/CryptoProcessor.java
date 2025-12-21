package Interviews_prep.DesignPattern.CreationalPattern.FactoryPattern.PaymentExample.product;

import Interviews_prep.DesignPattern.CreationalPattern.FactoryPattern.PaymentExample.PaymentProcessor;

public class CryptoProcessor implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {

        System.out.println("this is Crypto processer and amount is : "+amount);
    }
}
