package Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example.RefineAbstraction;

import Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example.Implementor.Device;
import Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example.abstraction.RemoteControl;

public class BasicRemote extends RemoteControl {
    public BasicRemote(Device device) {
        super(device);
    }

    @Override
    public void power() {

        System.out.println("Basic Remote: Power button pressed.");
        device.powerOn();
    }
}
