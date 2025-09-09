package Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example4.Adapter;

import Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example4.Adaptee.EnterpriseLoggerX;
import Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example4.Target.AppLogger;

public class EnterpriseLoggerXAdapter implements AppLogger {

    private EnterpriseLoggerX enterpriseLoggerX;

    public EnterpriseLoggerXAdapter(EnterpriseLoggerX enterpriseLoggerX) {
        this.enterpriseLoggerX = enterpriseLoggerX;
    }

    @Override
    public void logInfo(String message) {
//        System.out.println("[INFO-MESSAGE] ELX: " + message);
        enterpriseLoggerX.infoMessage(message);

    }

    @Override
    public void logWarning(String message) {

//        System.out.println("[NOTIFY-ALERT] ELX: " + message);
        enterpriseLoggerX.notifyAlert(message);
    }

    @Override
    public void logError(String message, Throwable cause) {

//        System.out.println("[CRITICAL-ERROR] ELX: " + message + " Cause: " + cause.getClass().getSimpleName());
        enterpriseLoggerX.criticalError(message, cause);

    }
}
