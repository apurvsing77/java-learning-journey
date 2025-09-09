package Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example4.Client;

import Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example4.Target.AppLogger;

public class AppLoggerManagement {
    private AppLogger appLogger;

    public AppLoggerManagement(AppLogger appLogger) {
        this.appLogger = appLogger;
    }
    public void logInfoProcess(String message) {
        appLogger.logInfo(message);

    }
    public void logWarningProcess(String message) {
        appLogger.logWarning(message);
    }
    public void logErrorProcess(String message, Throwable cause) {
        appLogger.logError(message, cause);
    }
}
