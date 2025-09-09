package Interviews_prep.DesignPattern.PracricExample.AdapterMeathed.paymentProcess.adaptee;

public class RazorpayAPI {
    public void makePayment( double amount) {
        System.out.println("Processing payment via Razorpay for: " + amount + " Rs");
    }

    public String checkStatus(String id) {
        System.out.println("Checking Razorpay transaction status for ID: " + id);
        if (id == null) {
            return "INCOMPLETED";
        } else {
            return "SUCCESS";
        }
    }
}
