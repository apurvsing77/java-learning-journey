package Interviews_prep.DesignPrinciple.KISS.BadExample;


interface GreetingStrategy {
    String createGreeting(String userName);
}

// FormalGreetingStrategy.java
class FormalGreetingStrategy implements GreetingStrategy {
    @Override
    public String createGreeting(String userName) {
        return "Greetings, Mr./Ms. " + userName + ". We hope you are well.";
    }
}

// InformalGreetingStrategy.java
class InformalGreetingStrategy implements GreetingStrategy {
    @Override
    public String createGreeting(String userName) {
        return "Hey " + userName + "! How's it going?";
    }
}

// GreetingService.java - Unnecessary abstraction
class GreetingService {
    private GreetingStrategy strategy;

    public GreetingService(GreetingStrategy strategy) {
        this.strategy = strategy;
    }

    public String getGreeting(String userName) {
        return strategy.createGreeting(userName);
    }
}

public class MainApp {
    public static void main(String[] args) {
        // Too much boilerplate code for a simple task
        GreetingService formalService = new GreetingService(new FormalGreetingStrategy());
        System.out.println(formalService.getGreeting("John Doe"));

        GreetingService informalService = new GreetingService(new InformalGreetingStrategy());
        System.out.println(informalService.getGreeting("Alice"));

        // This is an excessively complex design for generating a simple greeting.
        // We've used a Strategy Pattern, but it's unnecessary for this straightforward problem.
    }
}