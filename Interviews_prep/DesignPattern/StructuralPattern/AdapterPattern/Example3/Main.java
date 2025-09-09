package Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example3;

import Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example3.Adaptee.GlobalWalletAPI;
import Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example3.Adaptee.SecurePayAPI;
import Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example3.Adapter.GlobalWalletAPIAdapter;
import Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example3.Adapter.SecurePayAPIAdapter;
import Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example3.Client.PaymentManagementSystem;
import Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example3.Target.PaymentGateway;

public class Main {
    public static void main(String[] args) {

        SecurePayAPI securePayAPI = new SecurePayAPI();
        PaymentGateway paymentGateway = new SecurePayAPIAdapter(securePayAPI);
        PaymentManagementSystem paymentManagementSystem = new PaymentManagementSystem(paymentGateway);
        paymentManagementSystem.processPaymentForCreditCard("1234-3214-1234-0000", 100.0);
        paymentManagementSystem.processPaymentForPayPal("Fp4Yl@example.com", 200.0);

        GlobalWalletAPI globalWalletAPI = new GlobalWalletAPI();
        PaymentGateway paymentGateway1 = new GlobalWalletAPIAdapter(globalWalletAPI);
        PaymentManagementSystem paymentManagementSystem1 = new PaymentManagementSystem(paymentGateway1);
        paymentManagementSystem1.processPaymentForCreditCard("1234-5678-000-3456", 300.0);
        paymentManagementSystem1.processPaymentForPayPal("Fp4Yl@example.com", 400.0);
    }
}
