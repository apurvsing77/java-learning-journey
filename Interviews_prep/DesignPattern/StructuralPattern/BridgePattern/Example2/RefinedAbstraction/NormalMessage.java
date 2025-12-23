package Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example2.RefinedAbstraction;

import Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example2.abstraction.Message;
import Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example2.implementor.MessageSender;

public class NormalMessage extends Message {

    public NormalMessage(MessageSender messageSender){
        super(messageSender);
    }

    @Override
    public void sendMessage(String message) {
      messageSender.sendMessage(message);
    }
}
