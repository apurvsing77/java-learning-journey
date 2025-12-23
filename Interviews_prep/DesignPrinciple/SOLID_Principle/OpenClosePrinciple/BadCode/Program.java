package Interviews_prep.DesignPrinciple.SOLID_Principle.OpenClosePrinciple.BadCode;

public class Program {
    public static void main(String[] args) {
        NotificationService notificationService = new NotificationService();
        notificationService.sendNotification("EmailSender notification has been send ","email");
        notificationService.sendNotification("SMSSender notification has been send ","sms");
        notificationService.sendNotification("Push notification has been send ","push");
    }
}
