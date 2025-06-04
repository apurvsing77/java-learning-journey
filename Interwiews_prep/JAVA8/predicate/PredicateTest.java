package Interwiews_prep.JAVA8.predicate;

public class PredicateTest {
    public static void main(String[] args) {
        PredicateInterface<String> pdt = text -> text.length() > 5;
        System.out.println("Is Strings length greater then Five "+pdt.processer("APURV_KUMAR"));
    }
}
