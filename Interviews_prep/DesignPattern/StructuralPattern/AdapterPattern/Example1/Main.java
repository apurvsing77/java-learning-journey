package Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example1;

import Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example1.Adaptee.AndroidCharger;
import Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example1.Adapter.ChargerAdapter;
import Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example1.Client.Android;
import Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example1.Client.IPhone;
import Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example1.Target.AppleCharger;

public class Main {
    public static void main(String[] args) {
        AndroidCharger androidCharger = new AndroidCharger();
        AppleCharger adapter = new ChargerAdapter(androidCharger);
        IPhone iphone = new IPhone(adapter);

        iphone.chargePhone();

        Android android = new Android(androidCharger);
        android.chargePhone();
    }
}
