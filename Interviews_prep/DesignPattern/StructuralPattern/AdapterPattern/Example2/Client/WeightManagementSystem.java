package Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example2.Client;

import Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example2.Taget.FitnessTracker;

public class WeightManagementSystem {

    FitnessTracker fitnessTracker;
    public WeightManagementSystem(FitnessTracker fitnessTracker) {
        this.fitnessTracker = fitnessTracker;
    }
   public void proCaseFitnesdata(){
        System.out.println("--- Processing Fitness Data ---");
        System.out.println("Retrieving daily steps from tracker...");
        int steps = fitnessTracker.getDailySteps();
        System.out.println("Steps: " + steps);


        System.out.println("Retrieving calories burned from tracker...");
        int calories = fitnessTracker.getCaloriesBurned();
        System.out.println("Calories Burned: " + calories);

        if (steps >= 10000 && calories >= 400) {
            System.out.println("Great work today! You met your fitness goals.");
        } else {
            System.out.println("Keep working towards your daily goals!");
        }
        System.out.println("-----------------------------");

    }
}
