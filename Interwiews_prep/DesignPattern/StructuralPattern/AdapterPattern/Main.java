package Interwiews_prep.DesignPattern.StructuralPattern.AdapterPattern;

import Interwiews_prep.DesignPattern.StructuralPattern.AdapterPattern.Adaptee.AndroidCharger;
import Interwiews_prep.DesignPattern.StructuralPattern.AdapterPattern.Adapter.ChargerAdapter;
import Interwiews_prep.DesignPattern.StructuralPattern.AdapterPattern.Client.IPhone;
import Interwiews_prep.DesignPattern.StructuralPattern.AdapterPattern.Target.AppleCharger;

public class Main {
    public static void main(String[] args) {
        AndroidCharger androidCharger = new AndroidCharger();
        AppleCharger adapter = new ChargerAdapter(androidCharger);
        IPhone iphone = new IPhone(adapter);

        iphone.chargePhone();
    }
}
