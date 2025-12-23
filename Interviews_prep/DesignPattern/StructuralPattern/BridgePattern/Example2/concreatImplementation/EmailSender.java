package Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example2.concreatImplementation;

import Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example2.implementor.MessageSender;

public class EmailSender implements MessageSender {
    @Override
    public void sendMessage(String message) {

        System.out.println("Sending Email: "+message);
    }
}
