package Interviews_prep.DesignPrinciple.SOLID_Principle.SingleResponsibility;

public class OrderCalculator {

    int amount;
    int discount;
    int tax;

    public static void main(String[] args) {
        OrderCalculator oc = new OrderCalculator();
        oc.amount=5000;
        oc.discount=25;
        oc.tax=10;

        oc.orderAmount();
        EmailSend.sendMail();

    }

    private void orderAmount() {

        int order_amount = amount - (amount*discount)/100 - (amount*tax)/100;
        System.out.println(order_amount);
    }
}

class EmailSend{
    public static void sendMail(){
        System.out.println("We have Receive mail of order");
    }
}
