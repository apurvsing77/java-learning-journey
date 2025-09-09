package Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example2.Adapter;

import Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example2.Adaptee.HealthBandXAPI;
import Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example2.Taget.FitnessTracker;

public class HealthBandXAPIAdapter implements  FitnessTracker {

    private HealthBandXAPI healthBandXAPI;

    public HealthBandXAPIAdapter(HealthBandXAPI healthBandXAPI) {
        this.healthBandXAPI = healthBandXAPI;
    }

    @Override
    public int getDailySteps() {
        return healthBandXAPI.getTodaysFootsteps();
    }

    @Override
    public int getCaloriesBurned() {
        return healthBandXAPI.getCurrentDayCalories();
    }
}
