package Interviews_prep.JAVA8.StreamAPI;

import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class JavaStream {

    public static void main(String[] args){
        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return "hello";
            }
        };

        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("Printing the String : "+s);
            }
        };
        Stream<String>  streamOfString = Stream.generate(supplier);

        streamOfString.forEach( consumer );
    }
}
