package Interviews_prep.DesignPrinciple.SOLID_Principle.InerfaceSegrationPrinciple.GoodCode;

public interface PaymentProcessor {
    void processPayment(double amount);
    void refundPayment(double amount);


}
interface  DiscountApplicable {
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


}
class Paypal implements PaymentProcessor ,DiscountApplicable{
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