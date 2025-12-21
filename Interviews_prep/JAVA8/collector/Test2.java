package Interviews_prep.JAVA8.collector;

import java.util.*;
import java.util.stream.Collectors;

public class Test2 {
    public static void main(String[] args){
        // Make a fruitsList of  fruts and vegetables and its price and name can be repeated
        List<String> fruitsList = Arrays.asList("Apple", "Banana", "Orange", "Apple", "Banana", "Orange", "Apple", "Banana", "Orange", "Apple", "Banana", "Orange");
        // make a map of fruits and vegetables with price
        List<Fruits> fruits = Arrays.asList(new Fruits("apple",50),
                new Fruits("banana",45),
                new Fruits("orange",40),
                new Fruits("grapes",35),
                new Fruits("mango",30),
                new Fruits("guava",25),
                new Fruits("watermelon",20)
                );

        Map<String, Double> fruitMap = fruits.stream()
                .collect(Collectors.toMap(
                        Fruits::getName,      // Key mapper
                        Fruits::getPrice      // Value mapper
                ));

        double average = fruits.stream().collect(Collectors.averagingDouble(Fruits::getPrice));
        System.out.println("Average price of fruits: " + average);
        List<String> fruitsName = fruitsList.stream().collect(Collectors.collectingAndThen(
                Collectors.toList(),
                listfruts->{
                    List<String> set = listfruts.stream().collect(Collectors.toList());
                    return Collections.unmodifiableList(set);
                }
        ));
        System.out.println("Fruits Name: "+fruitsName);

        double averagePrice = fruitMap.values().stream().collect(Collectors.averagingDouble(pricr -> pricr));
//        System.out.println("Average price of fruitsMap: " + averagePrice);

        double averagePrice2 = fruitMap.keySet().stream().collect(Collectors.averagingDouble(fruitMap::get));
//        System.out.println("Average price of fruitsMap: " + averagePrice2);

        Map<String, String> fruteStatstics = fruitsList.stream().collect(Collectors.collectingAndThen(
                Collectors.toList(),
                lists ->{
                    int totalLength = lists.stream().mapToInt(String::length).sum();
                    int averageLength = totalLength / lists.size();
                    String longest = lists.stream().max(Comparator.comparingInt(String::length))
                            .orElse("none");
                    int size = lists.size();


                    Map<String, String> result = new HashMap<>();
                    result.put("totalLength", String.valueOf(totalLength));
                    result.put("averageLength", String.valueOf(averageLength));
                    result.put("size", String.valueOf(size));
                    result.put("longest", longest);

                    return  Collections.unmodifiableMap(result);
                }

        ));
//        System.out.println("Statistics: "+fruteStatstics);

        double averagePrice3 = fruitMap.keySet().stream().collect(Collectors.collectingAndThen(
                Collectors.toList(),
                listfruts->{
                    double averagePriceResult = listfruts.stream().collect(Collectors.averagingDouble(fruitMap::get));
                    return averagePriceResult;
        }
        ));
//    System.out.println("Average Price of fruit map :"+averagePrice3);

    }
}
class Fruits {
    String name;
    double price;

    public Fruits(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}