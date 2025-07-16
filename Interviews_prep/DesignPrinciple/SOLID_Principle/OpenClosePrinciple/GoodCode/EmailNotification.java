package Interviews_prep.DesignPrinciple.SOLID_Principle.OpenClosePrinciple.GoodCode;

public class EmailNotification implements Notification {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending message via email: " + message);
    }
}
