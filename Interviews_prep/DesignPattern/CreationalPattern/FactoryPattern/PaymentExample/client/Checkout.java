package Interviews_prep.DesignPattern.CreationalPattern.FactoryPattern.PaymentExample.client;

import Interviews_prep.DesignPattern.CreationalPattern.FactoryPattern.PaymentExample.PaymentProcessor;
import Interviews_prep.DesignPattern.CreationalPattern.FactoryPattern.PaymentExample.factory.PaymentFactory;
import Interviews_prep.DesignPattern.CreationalPattern.FactoryPattern.PaymentExample.product.PayPalProcessor;
import Interviews_prep.DesignPattern.CreationalPattern.FactoryPattern.PaymentExample.product.StripeProcessor;

public class Checkout {
    public static void main(String[] args){

//        PaymentProcessor crypto = PaymentFactory.processor("CryptoProcessor");
//        crypto.processPayment(123654);
//
//        PaymentProcessor paypal = PaymentFactory.processor("PaypalProcessor");
//        paypal.processPayment(123);
//
//        PaymentProcessor stripe = PaymentFactory.processor("StripeProcessor");
//        stripe.processPayment(10000);

        PaymentFactory paypal1 = new PaymentFactory(new PayPalProcessor(),1999);
        paypal1.callProcesser();

    }
}
