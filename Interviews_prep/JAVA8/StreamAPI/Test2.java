package Interviews_prep.JAVA8.StreamAPI;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class Test2 {
    public static void main(String[] args) {
     Stream<Integer> integerStream = Stream.of(1,2,3,4,5,6,7,8,9,10);

//        Consumer<Integer> consumer = new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) {
//                System.out.println(integer);
//            }
//        };

     integerStream.forEach(consumer -> System.out.println(consumer));
    }
}
