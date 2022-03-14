package LambdaDemo2;

import java.util.ArrayList;
import java.util.List;

public class LambdaConsumer {
    public static void main(String[] args) {
        List<String> nameList = new ArrayList<String>();
        nameList.add("Larry");
        nameList.add("Steve");
        nameList.add("James");
        nameList.add("Conan");
        nameList.add("Ellen");

        System.out.println("\nLambda in foreach");
        nameList.forEach(name -> {
            System.out.println("Hello " + name + "!");
        });

        System.out.println("\nLambda with stream and forEachOrdered");
        nameList.stream().forEachOrdered(name -> {
            System.out.println(name);
        });

        System.out.println("\nLambda with stream and sorted");
        nameList.stream().sorted().forEach(name -> {
            System.out.println(name);
        });

        System.out.println("\nLambda with stream and filter");
        nameList.stream()
                .filter(s -> s.startsWith("C") || s.startsWith("S"))
//                .filter(s -> s.contains("a"))
//                .filter(s -> s.length() != 5)
                .map(String::toUpperCase)
                .sorted()
                .forEach(s -> {
                    System.out.println(s);
                });
    }
}
