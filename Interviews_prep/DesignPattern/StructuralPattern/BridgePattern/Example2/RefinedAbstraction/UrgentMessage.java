package Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example2.RefinedAbstraction;

import Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example2.abstraction.Message;
import Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example2.implementor.MessageSender;

public class UrgentMessage extends Message {

    public UrgentMessage(MessageSender messageSender) {
        super(messageSender);
    }

    @Override
    public void sendMessage(String message) {

        String urgentText = "[ URGENT ] "+message;
        messageSender.sendMessage(urgentText);
    }
}
