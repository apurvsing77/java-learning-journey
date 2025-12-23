package Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example.RefineAbstraction;

import Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example.Implementor.Device;
import Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example.abstraction.RemoteControl;

public class AdvancedRemote extends RemoteControl {

    public AdvancedRemote(Device device) {
        super(device);
    }

    @Override
    public void power() {

        System.out.println("Advanced Remote: Running startup sequence...");
        device.powerOn();
    }

    public void voiceCommand(String command) {
        System.out.println("Voice Control: Executing " + command);
        if (command.equalsIgnoreCase("Movie Mode")) {
            device.setChannel(101);
        }
    }
}
