package Interviews_prep.DesignPrinciple.SOLID_Principle.InerfaceSegrationPrinciple.BadCode;

public interface PaymentProcessor {
    void processPayment(double amount);
    void refundPayment(double amount);
    void applyDiscount(double amount);

}
class CreditCardPayment implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of amount: " + amount);
    }

    @Override
    public void refundPayment(double amount) {
     System.out.println("Refunding credit card payment of amount: " + amount);
    }

    @Override
    public void applyDiscount(double amount) {
        throw new UnsupportedOperationException("Credit card payments do not support discounts");
    }
}
class BanksTransferPayment implements PaymentProcessor {

    @Override
    public void processPayment(double amount) {
         System.out.println("Processing bank transfer payment of amount: " + amount);
    }

    @Override
    public void refundPayment(double amount) {
      System.out.println("Refunding bank transfer payment of amount: " + amount);
    }

    @Override
    public void applyDiscount(double amount) {
        throw new UnsupportedOperationException("Bank transfer do not support discounts");
    }
}
class Paypal implements PaymentProcessor{
    @Override
    public void processPayment(double amount) {
         System.out.println("Processing PayPal payment of amount: " + amount);
    }

    @Override
    public void refundPayment(double amount) {
     System.out.println("Refunding PayPal payment of amount: " + amount);
    }

    @Override
    public void applyDiscount(double amount) {
        System.out.println("Applying discount to PayPal payment of amount: " + amount);
    }
}