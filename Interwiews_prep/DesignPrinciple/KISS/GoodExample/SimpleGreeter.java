package Interwiews_prep.DesignPrinciple.KISS.GoodExample;


public class SimpleGreeter {

    // A simple method that directly constructs the formal greeting string.
    public String createFormalGreeting(String userName) {
        return "Greetings, Mr./Ms. " + userName + ". We hope you are well.";
    }

    // Another simple method if we need a different type of greeting.
    public String createInformalGreeting(String userName) {
        return "Hey " + userName + "! How's it going?";
    }

    public static void main(String[] args) {
        SimpleGreeter greeter = new SimpleGreeter();

        // Directly call the methods
        System.out.println(greeter.createFormalGreeting("John Doe"));
        System.out.println(greeter.createInformalGreeting("Alice"));

        // This code is much easier to understand, write, and maintain.
        // We avoided unnecessary interfaces, classes, and constructor injection.
    }
}