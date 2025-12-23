package Interviews_prep.DesignPrinciple.SOLID_Principle.OpenClosePrinciple.GoodCode;

public class Program {
    public static void main(String[] args) {
        NotificationService notificationService = new NotificationService();
        notificationService.sendNotification(new EmailNotification(),"EmailSender sent successfully");
        notificationService.sendNotification(new SMSNotification(),"SMSSender sent successfully");
        notificationService.sendNotification(new WhatsappNotificaton(),"Whatsapp sent successfully");
    }
}
