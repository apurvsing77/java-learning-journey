package Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example.Implementor;

public interface Device {

    void powerOn();
    void powerOff();
    void volumeUp();
    void volumeDown();
    void setChannel(int channel);
}
