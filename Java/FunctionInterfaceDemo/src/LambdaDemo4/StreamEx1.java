package LambdaDemo4;

import java.util.stream.Stream;

public class StreamEx1 {
    public static void main(String[] args) {
        Stream.of("a1", "a2", "a3")
                .findFirst()
                .ifPresent(s -> System.out.println(s));

        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return true;
                });
    }
}
