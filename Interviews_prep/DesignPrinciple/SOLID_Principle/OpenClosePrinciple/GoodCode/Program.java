package Interviews_prep.DesignPrinciple.SOLID_Principle.OpenClosePrinciple.GoodCode;

public class Program {
    public static void main(String[] args) {
        NotificationService notificationService = new NotificationService();
        notificationService.sendNotification(new EmailNotification(),"Email sent successfully");
        notificationService.sendNotification(new SMSNotification(),"SMS sent successfully");
        notificationService.sendNotification(new WhatsappNotificaton(),"Whatsapp sent successfully");
    }
}
