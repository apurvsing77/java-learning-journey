package Interwiews_prep.DesignPattern.CreationalPattern.Builder;

public class Main {
    public static void main(String[] args) {
        Build build = new Build.BuilderPattern(101)
                .setName("Apurv")
                .setSubject("JAVA")
//                .setCity("jaipur")
                .build();
        System.out.println(build);
    }
}
