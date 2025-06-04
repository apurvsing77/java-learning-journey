package JavaBasicProgram;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class RandomNumber {
    public static void main(String[] args) {
        int max=100;
        int min=10;
        int ren= (int) (Math.random()*(max-min+1)+min);
        System.out.println(ren);
        System.out.println(Math.random());
        System.out.println(Math.random());

        Random random= new Random();
        int a=random.nextInt(100);
        int b= random.nextInt(20);
        System.out.println("Integers Number ");
        System.out.println(a);
        System.out.println(b);

        // Using ThreadLocalRandom -> java.util.ThreadL:ocalRandom
        int c= ThreadLocalRandom.current().nextInt(81,100);
        int d= ThreadLocalRandom.current().nextInt(1000,1009);
        System.out.println("Integers Number usin ThradLocalRandom ");
        System.out.println(c);
        System.out.println(d);

        //Using ints() Methods
randomInts(9,50,65);

    }

    public static void randomInts(int num,int origin,int bound){
        Random random1= new Random();

      random1.ints(num,origin,bound).forEach(System.out::println);

    }

}
