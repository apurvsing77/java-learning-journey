package Interviews_prep.DesignPattern.PracricExample.AdapterMeathed.paymentProcess.adaptee;

public class PaytmAPI {

    public void initiateTransaction(double payAmount) {
        System.out.println("Initiating Paytm transaction for: " + payAmount + " Rs");
    }

    public String queryTransaction(String transactionReference) {
        System.out.println("Querying Paytm transaction: " + transactionReference);
        if (transactionReference == null) {
            return "INCOMPLETED";
        } else {
            return "COMPLETED";
        }
    }

}
