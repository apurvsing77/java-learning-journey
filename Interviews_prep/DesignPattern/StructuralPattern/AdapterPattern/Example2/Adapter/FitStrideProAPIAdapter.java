package Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example2.Adapter;

import Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example2.Adaptee.FitStrideProAPI;
import Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example2.Taget.FitnessTracker;

public class FitStrideProAPIAdapter implements FitnessTracker {
    private FitStrideProAPI fitStrideProAPI;

    private static final double KJ_TO_CALORIES_FACTOR = 4.184;
    
    public FitStrideProAPIAdapter(FitStrideProAPI fitStrideProAPI) {
        this.fitStrideProAPI = fitStrideProAPI;
    }
    
    @Override
    public int getDailySteps() {
        return fitStrideProAPI.retrieveStepsToday();
    }

    @Override
    public int getCaloriesBurned() {
        // Convert kilojoules to calories (1 kJ = 0.239006 kcal)
        // and round to nearest integer as required by the interface
        double kj = fitStrideProAPI.getEnergyConsumptionKJ();
        return (int) Math.round(kj / KJ_TO_CALORIES_FACTOR);
    }
}
