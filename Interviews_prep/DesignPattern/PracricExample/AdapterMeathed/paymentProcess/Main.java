package Interviews_prep.DesignPattern.PracricExample.AdapterMeathed.paymentProcess;

import Interviews_prep.DesignPattern.PracricExample.AdapterMeathed.paymentProcess.adaptee.PaytmAPI;
import Interviews_prep.DesignPattern.PracricExample.AdapterMeathed.paymentProcess.adaptee.RazorpayAPI;
import Interviews_prep.DesignPattern.PracricExample.AdapterMeathed.paymentProcess.adapter.PaytmAdapter;
import Interviews_prep.DesignPattern.PracricExample.AdapterMeathed.paymentProcess.adapter.RazorpayAdapter;
import Interviews_prep.DesignPattern.PracricExample.AdapterMeathed.paymentProcess.client.CarSalesSystem;
import Interviews_prep.DesignPattern.PracricExample.AdapterMeathed.paymentProcess.target.PaymentProcessor;

public class Main {
    public static void main(String[] args) {
        PaytmAPI paytmAPI = new PaytmAPI();
        RazorpayAPI razorpayAPI = new RazorpayAPI();
        PaymentProcessor paytmAdapter = new PaytmAdapter(paytmAPI);
        PaymentProcessor razorpayAdapter = new RazorpayAdapter(razorpayAPI);

        CarSalesSystem carSalesSystem = new CarSalesSystem(paytmAdapter);
        carSalesSystem.sellCar("Apurv Kumar", 50000.0, null);

    }
}
