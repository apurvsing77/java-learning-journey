package Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example2.Adaptee;

public class HealthBandXAPI {
    public int getTodaysFootsteps() {
        System.out.println("HealthBand X: Getting today's footsteps...");
        // Simulate actual data retrieval
        return 12000;
    }

    public int getCurrentDayCalories() { // Directly returns calories
        System.out.println("HealthBand X: Getting current day calories...");
        // Simulate actual data retrieval
        return 500;
    }
}