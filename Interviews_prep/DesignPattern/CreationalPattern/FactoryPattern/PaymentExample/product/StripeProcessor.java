package Interviews_prep.DesignPattern.CreationalPattern.FactoryPattern.PaymentExample.product;

import Interviews_prep.DesignPattern.CreationalPattern.FactoryPattern.PaymentExample.PaymentProcessor;

public class StripeProcessor implements PaymentProcessor {


    @Override
    public void processPayment(double amount) {
        System.out.println(" This is Strip processor and amount is : "+amount);

    }
}
