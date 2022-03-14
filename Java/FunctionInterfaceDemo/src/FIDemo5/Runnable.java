package FIDemo5;

import java.util.ArrayList;

public class Runnable {
    public static void main(String[] args) {
        // lambda syntax: HumanInterface me = () -> {}
        String f = "food";
        HumanInterface me = (b) -> { String data = b;
            System.out.println(data);};
        me.eat("food 1");

        // no curly brackets needed because only one statement
        HumanInterface me1 = (b) -> System.out.println(b);
        me1.eat("food 2");

        // no parentheses
        HumanInterface me2 = b -> {
            System.out.println(b);
        };
        me2.eat("food 3");

        HumanInterface me3 = (String b) -> {
            System.out.println(b);
        };
        me3.eat("food 4");

        // curly brackets are needed for just a single return statement
        IWithReturnType aObj5 = (b) -> {
            return b;
        };
        System.out.println(aObj5.eat("food 5"));

        // this indicates just the returned variable
        IWithReturnType aObj6 = (b) -> b;
        System.out.println(aObj6.eat("food 6"));
    }
}
