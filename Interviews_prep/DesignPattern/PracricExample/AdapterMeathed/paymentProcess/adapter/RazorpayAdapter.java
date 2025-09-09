package Interviews_prep.DesignPattern.PracricExample.AdapterMeathed.paymentProcess.adapter;

import Interviews_prep.DesignPattern.PracricExample.AdapterMeathed.paymentProcess.adaptee.RazorpayAPI;
import Interviews_prep.DesignPattern.PracricExample.AdapterMeathed.paymentProcess.target.PaymentProcessor;

public class RazorpayAdapter implements PaymentProcessor {

    private RazorpayAPI razorpayAPI;

    public RazorpayAdapter(RazorpayAPI razorpayAPI) {
        this.razorpayAPI = razorpayAPI;
    }

    @Override
    public void processPayment(double amount) {
        razorpayAPI.makePayment(amount);
    }

    @Override
    public boolean verifyTransaction(String transactionId) {
        String status = razorpayAPI.checkStatus(transactionId);
        return status.equals("SUCCESS");
    }
}
