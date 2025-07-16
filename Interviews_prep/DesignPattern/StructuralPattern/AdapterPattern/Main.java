package Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern;

import Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Adaptee.AndroidCharger;
import Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Adapter.ChargerAdapter;
import Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Client.IPhone;
import Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Target.AppleCharger;

public class Main {
    public static void main(String[] args) {
        AndroidCharger androidCharger = new AndroidCharger();
        AppleCharger adapter = new ChargerAdapter(androidCharger);
        IPhone iphone = new IPhone(adapter);

        iphone.chargePhone();
    }
}
