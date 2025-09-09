package Interviews_prep.DesignPattern.PracricExample.DecoraterPattern;

import Interviews_prep.DesignPattern.PracricExample.DecoraterPattern.component.Car;
import Interviews_prep.DesignPattern.PracricExample.DecoraterPattern.componentConcreet.SUVModel;
import Interviews_prep.DesignPattern.PracricExample.DecoraterPattern.componentConcreet.SedanModel;
import Interviews_prep.DesignPattern.PracricExample.DecoraterPattern.concreeetDecorater.LeatherSeat;
import Interviews_prep.DesignPattern.PracricExample.DecoraterPattern.concreeetDecorater.MusicSystem;
import Interviews_prep.DesignPattern.PracricExample.DecoraterPattern.concreeetDecorater.SunRoof;

public class Main {
    public static void main(String[] args) {
        Car sedan = new SedanModel();
        sedan.carModel();

        Car suvWithSunroofWithLeatherseat = new SunRoof(new LeatherSeat(new SUVModel()));
        suvWithSunroofWithLeatherseat.carModel();

        // simple sedan car with music system
        Car sedanWithMusicSystem = new MusicSystem(new SedanModel());
        sedanWithMusicSystem.carModel();
    }
}
