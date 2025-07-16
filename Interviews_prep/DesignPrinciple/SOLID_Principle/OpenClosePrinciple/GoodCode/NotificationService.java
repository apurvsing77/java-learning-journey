package Interviews_prep.DesignPrinciple.SOLID_Principle.OpenClosePrinciple.GoodCode;

public class NotificationService {
    public void sendNotification(Notification notification,String message) {
        notification.sendNotification(message);
    }
}
