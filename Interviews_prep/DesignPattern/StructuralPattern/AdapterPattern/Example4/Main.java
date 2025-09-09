package Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example4;

import Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example4.Adaptee.SimpleLogKit;
import Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example4.Adapter.SimpleLogKitAdapter;
import Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example4.Client.AppLoggerManagement;
import Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example4.Target.AppLogger;

public class Main {
    public static void main(String[] args) {

        SimpleLogKit simpleLogKit = new SimpleLogKit();
        AppLogger appLogger = new SimpleLogKitAdapter(simpleLogKit);
        AppLoggerManagement appLoggerManagement = new AppLoggerManagement(appLogger);
        appLoggerManagement.logInfoProcess("Log Information");
        appLoggerManagement.logWarningProcess("Warning");
        appLoggerManagement.logErrorProcess("Runtime Exception", new RuntimeException("ABCD"));
    }
}
