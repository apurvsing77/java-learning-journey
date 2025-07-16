package Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Adapter;

import Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Adaptee.AndroidCharger;
import Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Target.AppleCharger;

public class ChargerAdapter implements AppleCharger {
    private AndroidCharger androidCharger;

    public ChargerAdapter(AndroidCharger androidCharger) {
        this.androidCharger = androidCharger;
    }


    @Override
    public void chargeWithLightning() {
        System.out.println("Adapter converts  USB-C to Lightning ...");
        androidCharger.chargeWithUsbC();
    }
}
