package Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example4.Adapter;

import Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example4.Adaptee.SimpleLogKit;
import Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example4.Target.AppLogger;

public class SimpleLogKitAdapter implements AppLogger {

    private SimpleLogKit simpleLogKit;

    public SimpleLogKitAdapter(SimpleLogKit simpleLogKit) {
        this.simpleLogKit = simpleLogKit;
    }

    @Override
    public void logInfo(String message) {
//        System.out.println("[INFO] SimpleLogKit: " + message);
        simpleLogKit.debug(message);

    }

    @Override
    public void logWarning(String message) {

//        System.out.println("[WARN] SimpleLogKit: " + message);
        simpleLogKit.warning(message);

    }

    @Override
    public void logError(String message, Throwable cause) {

//        System.out.println("[ERROR] SimpleLogKit: " + message + " Exception: " + cause.getMessage());
        simpleLogKit.fatal(message, (Exception) cause);

    }
}
