package Interwiews_prep.DesignPrinciple.SOLID_Principle.OpenClosePrinciple.GoodCode;

public class SMSNotification implements Notification {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending massage via SMS : " + message);
    }
}
