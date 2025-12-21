package Interviews_prep.JAVA8.collector;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JoiningMethod {
    public static void main(String[] args){
        List<String> names = Arrays.asList("John", "Jane", "Bob", "Alice", "Mike");

        String result = names.stream().collect(Collectors.joining());
        String withComa = names.stream().collect(Collectors.joining(", "));
        String withBrackets = names.stream().collect(Collectors.joining(", ","[", "]"));
        System.out.println("Simple joining: "+result);
        System.out.println("Joining with Comma: "+withComa);
        System.out.println("joining with brackets: "+withBrackets);
    }
}
