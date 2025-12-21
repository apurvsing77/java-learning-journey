package Interviews_prep.JAVA8.collector;

import java.util.*;
import java.util.stream.Collectors;

public class ReducingMethod {
    public static void main(String[] args){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<String> words = Arrays.asList("Hello", "World", "Java");
        List<String> fruits = Arrays.asList("Apple", "Banana", "Cherry", "Date");
        List<Product> products = Arrays.asList(
                new Product("Laptop", 1000.0, 2),
                new Product("Mouse", 25.0, 5),
                new Product("Keyboard", 75.0, 3),
                new Product("Monitor", 300.0, 1)
        );

        int sum = numbers.stream().collect(Collectors.reducing(0,(a, b)->a+b));
        System.out.println("Sum of numbers: "+sum);

        String concat = words.stream().collect(Collectors.reducing("",(a, b)->a+b));
        String concat2 = words.stream().collect(Collectors.reducing("",String::concat));
        System.out.println("Concatenated words: "+concat);
        System.out.println("Concatenated words2: "+concat2);

        int totalLength = fruits.stream().collect(Collectors.reducing(
                0,
                String::length,
                Integer::sum
        ));
        System.out.println("Total length of String : "+totalLength);

        double totalValue = products.stream().collect(Collectors.reducing(
                0.0,
                product-> product.getPrice() * product.getQuantity(),
                Double::sum
        ));
        System.out.println("Total inventory value: $" + totalValue);

        Optional<Product> maxValue = products.stream().collect(Collectors.reducing(
                (p1,p2)->(p1.getPrice() * p1.getQuantity() > p2.getPrice() * p2.getQuantity()) ? p1:p2
        ));
        maxValue.ifPresent(p->  System.out.println("Most valuable: " + p.getName() + " ($" + (p.getPrice() * p.getQuantity() +")")));

        int secondHighestnum = numbers.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();

        System.out.println("Second highest number: " + secondHighestnum);


// Custom approach to track top two values
        Optional<Integer> secondMax = numbers.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> {
                            if (list.size() < 2) return Optional.<Integer>empty();

                            // Find max
                            Optional<Integer> max = list.stream()
                                    .collect(Collectors.maxBy(Comparator.naturalOrder()));

                            // Find max of remaining elements
                            return max.flatMap(m -> list.stream()
                                    .filter(n -> !n.equals(m))
                                    .collect(Collectors.maxBy(Comparator.naturalOrder())));
                        }
                ));

        secondMax.ifPresent(System.out::println); // Output: 8


    }
}

class Product {
    String name;
    double price;
    int quantity;

    Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
}