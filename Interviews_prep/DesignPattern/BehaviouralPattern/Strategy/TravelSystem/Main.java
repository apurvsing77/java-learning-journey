package Interviews_prep.DesignPattern.BehaviouralPattern.Strategy.TravelSystem;

import Interviews_prep.DesignPattern.BehaviouralPattern.Strategy.TravelSystem.ConcreatStrategy.BusStrategy;
import Interviews_prep.DesignPattern.BehaviouralPattern.Strategy.TravelSystem.ConcreatStrategy.CarStrategy;
import Interviews_prep.DesignPattern.BehaviouralPattern.Strategy.TravelSystem.Context.Travel;

public class Main {
    public static void main(String[] args){


    Travel viaCar = new Travel(new CarStrategy());
    Travel viaBus = new Travel(new BusStrategy());

    viaCar.goToAirport();
    viaBus.goToAirport();


    }
}
