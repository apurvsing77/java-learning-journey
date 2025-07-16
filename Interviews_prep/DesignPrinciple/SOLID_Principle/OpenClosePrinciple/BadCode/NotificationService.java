package Interviews_prep.DesignPrinciple.SOLID_Principle.OpenClosePrinciple.BadCode;

public class NotificationService {

    public void sendNotification(String message,String type) {
        // Send email notification
        if (type.equals("email")) {
            System.out.println("Email notification: " + message);
        } else if (type.equals("sms")) {
            System.out.println("SMS notification: " + message);
        } else {
            System.out.println("Invalid notification type: " + type);
        }
    }
}
