package Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example1.Client;

import Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example1.Adaptee.AndroidCharger;

public class Android {
    AndroidCharger androidCharger;
    public Android(AndroidCharger androidCharger) {
        this.androidCharger = androidCharger;
    }
    public void chargePhone(){
        System.out.println("Android Phone charging Started ");
        androidCharger.chargeWithUsbC();
    }
}
