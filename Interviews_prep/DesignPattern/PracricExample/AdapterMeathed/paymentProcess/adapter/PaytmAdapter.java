package Interviews_prep.DesignPattern.PracricExample.AdapterMeathed.paymentProcess.adapter;

import Interviews_prep.DesignPattern.PracricExample.AdapterMeathed.paymentProcess.adaptee.PaytmAPI;
import Interviews_prep.DesignPattern.PracricExample.AdapterMeathed.paymentProcess.target.PaymentProcessor;

public class PaytmAdapter implements PaymentProcessor {

    private PaytmAPI paytmAPI;

    public PaytmAdapter(PaytmAPI paytmAPI) {
        this.paytmAPI = paytmAPI;
    }

    @Override
    public void processPayment(double amount) {
        paytmAPI.initiateTransaction(amount);
    }

    @Override
    public boolean verifyTransaction(String transactionId) {
        String status = paytmAPI.queryTransaction(transactionId);
        return status.equals("COMPLETED");
    }
}
