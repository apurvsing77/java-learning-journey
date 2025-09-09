package Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example1.Client;

import Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example1.Target.AppleCharger;

public class IPhone {
    private AppleCharger charger;

    public IPhone(AppleCharger charger) { // new ChargerAdapter(androidCharger);
        this.charger = charger;
    }

    public void chargePhone() {
        System.out.println("iPhone charging started:");
        charger.chargeWithLightning();
    }
}
