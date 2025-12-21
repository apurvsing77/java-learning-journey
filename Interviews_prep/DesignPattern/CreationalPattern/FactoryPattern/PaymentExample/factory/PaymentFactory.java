package Interviews_prep.DesignPattern.CreationalPattern.FactoryPattern.PaymentExample.factory;

import Interviews_prep.DesignPattern.CreationalPattern.FactoryPattern.PaymentExample.PaymentProcessor;
import Interviews_prep.DesignPattern.CreationalPattern.FactoryPattern.PaymentExample.product.CryptoProcessor;
import Interviews_prep.DesignPattern.CreationalPattern.FactoryPattern.PaymentExample.product.PayPalProcessor;
import Interviews_prep.DesignPattern.CreationalPattern.FactoryPattern.PaymentExample.product.StripeProcessor;

public class PaymentFactory {

    private PaymentProcessor paymentProcessor;
    double amount;

    public PaymentFactory(PaymentProcessor paymentProcessor,double amount){
        this.paymentProcessor = paymentProcessor;
        this.amount = amount;
    }
    public void callProcesser(){
        paymentProcessor.processPayment(amount);

    }
    public static PaymentProcessor processor(String paymentType){
        if (paymentType == null || paymentType.isEmpty()) return null;

        switch (paymentType.toLowerCase()){
            case "cryptoprocessor":
                return new CryptoProcessor();
            case "paypalprocessor":
                return new PayPalProcessor();
            case "stripeprocessor":
                return new StripeProcessor();
            default:
                throw  new IllegalArgumentException("Unknown Payment Type : "+ paymentType);
        }

    }
}
