package Interwiews_prep.DesignPrinciple.SOLID_Principle.OpenClosePrinciple.GoodCode;

public class WhatsappNotificaton implements Notification {

    @Override
    public void sendNotification(String message) {
        System.out.println("Sending Message via Whatsapp: " + message);
    }
}
