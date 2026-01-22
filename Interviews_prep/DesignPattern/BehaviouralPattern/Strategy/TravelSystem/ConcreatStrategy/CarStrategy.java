package Interviews_prep.DesignPattern.BehaviouralPattern.Strategy.TravelSystem.ConcreatStrategy;

import Interviews_prep.DesignPattern.BehaviouralPattern.Strategy.TravelSystem.TravelStrategy;

public class CarStrategy implements TravelStrategy {
    public void travel() {
        System.out.println("Driving car... ETA 30 mins.");
    }
}