package Interviews_prep.DesignPattern.BehaviouralPattern.Strategy.TravelSystem.ConcreatStrategy;

import Interviews_prep.DesignPattern.BehaviouralPattern.Strategy.TravelSystem.TravelStrategy;

public class BusStrategy implements TravelStrategy {
    public void travel() {
        System.out.println("Taking bus... ETA 60 mins.");
    }
}