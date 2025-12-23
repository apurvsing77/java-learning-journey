package Interviews_prep.DesignPrinciple.SOLID_Principle;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Create an order
        Order order = new Order("ORD123", Arrays.asList("Laptop", "Mouse"), "customer@example.com", 1200.00);
        System.out.println("Original " + order);

        // --- Demonstrate SRP & OCP for Discount ---
        DiscountService discountService = new DiscountService();

        // Apply a standard discount
//        IDiscountStrategy standardDiscount = new StandardDiscount();
        double discountedAmount = discountService.applyDiscount(order.getTotalAmount(), new StandardDiscount());
        order.setTotalAmount(discountedAmount); // remodify the order after getting special discount
        System.out.println("After standard discount: " + order);

        // Apply an Eid special discount (new strategy, no code change in DiscountService)
        // This also demonstrates LSP because EidSpecialDiscount is substituted for IDiscountStrategy
//        IDiscountStrategy eidDiscount = new EidSpecialDiscount();
        order.setTotalAmount(discountService.applyDiscount(1000.00, new EidSpecialDiscount())); // Use a fresh amount for demo
        System.out.println("After Eid special discount: " + order);

        // --- Demonstrate SRP & OCP for Payment ---
        PaymentService paymentService = new PaymentService();

        // Process payment using Credit Card
        // This also demonstrates LSP because CreditCardProcessor is substituted for IPaymentProcessor
//        IPaymentProcessor creditCardProcessor = new CreditCardProcessor();
        boolean paymentSuccess = paymentService.processPayment(order, new CreditCardProcessor());
        System.out.println("Payment Status: " + (paymentSuccess ? "Successful" : "Failed") + ". Order Status: " + order.getStatus());

        // Process payment using PayPal (new processor, no code change in PaymentService)
        Order order2 = new Order("ORD124", Arrays.asList("Keyboard"), "test@example.com", 150.00);
//        IPaymentProcessor payPalProcessor = new PayPalProcessor();
        paymentService.processPayment(order2, new PayPalProcessor());
        System.out.println("Order2 Status: " + order2.getStatus());

        // Process payment using Google Pay (another new processor, no code change in PaymentService)
        Order order3 = new Order("ORD125", Arrays.asList("Monitor"), "another@example.com", 300.00);
//        IPaymentProcessor googlePayProcessor = new GooglePayProcessor();
        paymentService.processPayment(order3, new GooglePayProcessor());
        System.out.println("Order3 Status: " + order3.getStatus());


        // --- Demonstrate SRP for EmailSender ---
        EmailService emailService = new EmailService();
        emailService.sendConfirmationEmail(order);
    }
}