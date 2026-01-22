package Interviews_prep.DesignPattern.BehaviouralPattern.Strategy.TravelSystem.Context;

import Interviews_prep.DesignPattern.BehaviouralPattern.Strategy.TravelSystem.TravelStrategy;

public class Travel {
    TravelStrategy modeOfTravel;

    public Travel(TravelStrategy modeOfTravel) {
        this.modeOfTravel = modeOfTravel;

    }

    public void goToAirport() {
        modeOfTravel.travel();
    }

}
