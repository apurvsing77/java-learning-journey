package Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example1.Adapter;

import Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example1.Adaptee.AndroidCharger;
import Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example1.Target.AppleCharger;

public class ChargerAdapter implements AppleCharger {
    private final AndroidCharger androidCharger;

    public ChargerAdapter(AndroidCharger androidCharger) {
        this.androidCharger = androidCharger;
    }


    @Override
    public void chargeWithLightning() {
        System.out.println("Adapter converts  USB-C to Lightning ...");
        androidCharger.chargeWithUsbC();
    }
}
