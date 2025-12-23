package Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example2.abstraction;

import Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example2.implementor.MessageSender;

public abstract class Message {
    protected MessageSender messageSender;

    protected Message(MessageSender messageSender){
        this.messageSender = messageSender;
    }
    public abstract  void sendMessage(String message);
}
