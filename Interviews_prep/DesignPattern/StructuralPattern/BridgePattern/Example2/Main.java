package Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example2;

import Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example2.RefinedAbstraction.NormalMessage;
import Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example2.RefinedAbstraction.UrgentMessage;
import Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example2.abstraction.Message;
import Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example2.concreatImplementation.EmailSender;
import Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example2.concreatImplementation.SMSSender;

public class Main {
    public static void main(String[] args){


        Message msg1 = new NormalMessage(new EmailSender());
        msg1.sendMessage("Hello, how are you?");

        Message msg2 = new UrgentMessage(new SMSSender());
        msg2.sendMessage("The server is down!");
    }
}
