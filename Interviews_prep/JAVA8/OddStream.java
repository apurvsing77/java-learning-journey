package Interviews_prep.JAVA8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OddStream {

    public static void main(String[] args) {

    int[] arr= {5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,49,1,2,3,4};

        System.out.println("Odd numbers are: ");
        Arrays.stream(arr).filter(n->n%2!=0).forEach(System.out::println);
        System.out.println("Even numbers are: ");
        Arrays.stream(arr).filter(n->n%2==0).forEach(System.out::println);
        System.out.println("Odd numbers < 5: ");
        Arrays.stream(arr).filter(n->n<5).filter(n->n%2!=0).forEach(System.out::println);
        System.out.println("Odd numbers > 7: ");
        Arrays.stream(arr).filter(n->n>7).filter(n->n%2!=0).forEach(System.out::println);
        System.out.println("odd numbers between 3 and 9:");
        Arrays.stream(arr).filter(n->n>3).filter(n->n<9).filter(n->n%2!=0).forEach(System.out::println);
        System.out.println("Add 5 to all Elements:");
        Arrays.stream(arr).map(n->n+5).forEach(System.out::println);
        System.out.println("Make a new list of odd numbers ");
        List<Integer> list = Arrays.stream(arr).filter(n->n%2!=0).boxed().collect(Collectors.toList());
        System.out.println(list);
        System.out.println("Make a new list of Even numbers ");
        List<Integer> list2 = Arrays.stream(arr).filter(n->n%2==0).boxed().collect(Collectors.toList());
        System.out.println(list2);

         int sum = Arrays.stream(arr).sum();
        System.out.println("Sum of all element: "+sum);
        System.out.println(Arrays.stream(arr).reduce(0,(a,b)->a+b));

        double avg = Arrays.stream(arr).average().orElse(0.0);
        System.out.println("Average of  all element: "+avg);

        long count = Arrays.stream(arr).count();
        System.out.println("Count of all element "+count);



    }
}
