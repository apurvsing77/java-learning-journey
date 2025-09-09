package Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example4.Target;

// Target Interface: What your application modules expect for logging
public interface AppLogger {
    void logInfo(String message);
    void logWarning(String message);
    void logError(String message, Throwable cause);
}