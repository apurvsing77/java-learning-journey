package Interviews_prep.DesignPrinciple.SOLID_Principle;// SRP Refactoring: Separate Responsibilities

import java.util.List;

// 1. Order class: Now only responsible for order data and status.
class Order {
    private String orderId;
    private List<String> items;
    private String customerEmail;
    private double totalAmount;
    private String status;

    public Order(String orderId, List<String> items, String customerEmail, double totalAmount) {
        this.orderId = orderId;
        this.items = items;
        this.customerEmail = customerEmail;
        this.totalAmount = totalAmount;
        this.status = "Pending";
    }

    // Getters and Setters
    public String getOrderId() { return orderId; }
    public List<String> getItems() { return items; }
    public String getCustomerEmail() { return customerEmail; }
    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", customerEmail=" + customerEmail + ", totalAmount=" + totalAmount + ", status=" + status + "]";
    }
}

// 2. DiscountService: Responsible only for applying discounts.
class DiscountService {
    public double applyDiscount(double originalAmount, IDiscountStrategy discountStrategy) {
        return discountStrategy.applyDiscount(originalAmount);
    }
}

// 3. PaymentProcessor (will be an interface later for OCP/LSP, but for SRP it's a dedicated service)
class PaymentService {
    public boolean processPayment(Order order, IPaymentProcessor paymentProcessor) {
        System.out.println("Initiating payment for order " + order.getOrderId());
        boolean success = paymentProcessor.processPayment(order.getTotalAmount());
        if (success) {
            order.setStatus("Paid");
            System.out.println("Payment successful for order " + order.getOrderId());
        } else {
            order.setStatus("Payment Failed");
            System.out.println("Payment failed for order " + order.getOrderId());
        }
        return success;
    }
}

// 4. EmailService: Responsible only for sending emails.
class EmailService {
    public boolean sendConfirmationEmail(Order order) {
        System.out.println("Sending confirmation email to " + order.getCustomerEmail() + " for order " + order.getOrderId() + ".");
        // ... actual email sending logic ...
        System.out.println("we can write here actual logic to send email");
        return true;
    }
}