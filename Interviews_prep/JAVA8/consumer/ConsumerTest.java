package Interviews_prep.JAVA8.consumer;

public class ConsumerTest {
    public static void main(String[] args) {
        ConsumerInter<String> consum = input -> System.out.println("Hi, i am "+input.toLowerCase()+" Working with consumer example");
        consum.processer("APURV");
    }
}
