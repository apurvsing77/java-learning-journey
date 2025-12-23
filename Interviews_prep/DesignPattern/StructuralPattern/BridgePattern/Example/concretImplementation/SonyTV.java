package Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example.concretImplementation;

import Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example.Implementor.Device;

public class SonyTV implements Device {
    @Override
    public void powerOn() {
        System.out.println("Sony TV is ON");

    }

    @Override
    public void powerOff() {
        System.out.println("Sony TV is OFF");

    }

    @Override
    public void volumeUp() {

        System.out.println("Sony TV Volume is UP");
    }

    @Override
    public void volumeDown() {

        System.out.println("Sony TV Volume is DOWN");
    }

    @Override
    public void setChannel(int channel) {
        System.out.println("Sony TV Channel is set to " + channel);

    }
}
