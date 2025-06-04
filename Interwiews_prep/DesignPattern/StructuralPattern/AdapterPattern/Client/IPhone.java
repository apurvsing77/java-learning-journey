package Interwiews_prep.DesignPattern.StructuralPattern.AdapterPattern.Client;

import Interwiews_prep.DesignPattern.StructuralPattern.AdapterPattern.Target.AppleCharger;

public class IPhone {
    private AppleCharger charger;

    public IPhone(AppleCharger charger) {
        this.charger = charger;
    }

    public void chargePhone() {
        System.out.println("iPhone charging started:");
        charger.chargeWithLightning();
    }
}
