package Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example.abstraction;

import Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example.Implementor.Device;

public abstract class RemoteControl {

    protected Device device;

    protected RemoteControl(Device device){
        this.device = device;
    }
    public abstract void power();

}
