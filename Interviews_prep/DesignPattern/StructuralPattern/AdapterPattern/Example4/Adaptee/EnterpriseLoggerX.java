package Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example4.Adaptee;

public class EnterpriseLoggerX {
    public void infoMessage(String text) {
        System.out.println("[INFO] ELX: " + text);
    }
    public void notifyAlert(String alertText) {
        System.out.println("[ALERT] ELX: " + alertText);
    }
    public void criticalError(String errorDesc, Throwable exceptionObj) {
        System.out.println("[CRITICAL] ELX: " + errorDesc + " Cause: " + exceptionObj.getClass().getSimpleName());
    }
}