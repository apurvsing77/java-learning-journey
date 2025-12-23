package Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example;

import Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example.Implementor.Device;
import Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example.RefineAbstraction.AdvancedRemote;
import Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example.RefineAbstraction.BasicRemote;
import Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example.abstraction.RemoteControl;
import Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example.concretImplementation.SamsungTV;
import Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example.concretImplementation.SonyTV;

public class Main {
    public static void main(String[] args){

        Device sonyTV = new SonyTV();
        RemoteControl sonyRemote = new BasicRemote(sonyTV);
        sonyRemote.power();

        Device samsungTV = new SamsungTV();
       AdvancedRemote advancedRemote = new AdvancedRemote(samsungTV);
       advancedRemote.power();
        advancedRemote.voiceCommand("Movie Mode");
    }
}
