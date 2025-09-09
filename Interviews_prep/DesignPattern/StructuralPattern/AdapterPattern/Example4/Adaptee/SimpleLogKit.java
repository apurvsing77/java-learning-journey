package Interviews_prep.DesignPattern.StructuralPattern.AdapterPattern.Example4.Adaptee;

public class SimpleLogKit {

    public void debug(String msg) {
        System.out.println("[DEBUG] SimpleLogKit: " + msg);
    }
    public void warning(String msg) {
        System.out.println("[WARN] SimpleLogKit: " + msg);
    }
    public void fatal(String msg, Exception e) {
        System.out.println("[FATAL] SimpleLogKit: " + msg + " Exception: " + e.getMessage());
    }
}