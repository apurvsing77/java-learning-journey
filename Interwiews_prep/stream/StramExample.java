package Interviews_prep.stream;

import java.util.*;
import java.util.stream.Collectors;

public class StramExample {
    public static void main(String[] args) {
        Set<String> addElement = new HashSet<>();
        List<String> list = Arrays.asList("a", "g", "g","e", "e", "k", "s");

      List<String> str=  list.stream()
              .map(a->a.toUpperCase())
              .peek(s ->addElement.add(s))
              .sorted()
              .distinct()
              .collect(Collectors.toList());

        System.out.println(str);
        System.out.println(addElement);

       String reduceString= list.stream()
               .map(a->a.toUpperCase()).
               reduce("",(previous,next)->previous+next);
        System.out.println(reduceString);

        Optional<String> firstWord = list.stream().findFirst();
        firstWord.ifPresent(System.out::println);
        boolean allStarttWithA =list.stream().allMatch(name -> name.startsWith("a"));
        System.out.println("AllStarttWithA  "+allStarttWithA);

        boolean anyStarttWithA =list.stream().anyMatch(name -> name.startsWith("a"));
        System.out.println("AnyStarttWithA  "+anyStarttWithA);

    }
}
