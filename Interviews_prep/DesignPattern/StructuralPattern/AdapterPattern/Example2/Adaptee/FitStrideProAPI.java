package Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example2.Adaptee;

public class FitStrideProAPI {
    public int retrieveStepsToday() {
        System.out.println("FitStride Pro: Retrieving steps for today...");
        // Simulate actual data retrieval
        return 10000;
    }

    public double getEnergyConsumptionKJ() { // Returns kilojoules
        System.out.println("FitStride Pro: Getting energy consumption in KJ...");
        // Simulate actual data retrieval
        return 2000.0; // in Kilojoules
    }
}