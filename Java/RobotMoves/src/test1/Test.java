package test1;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        // create an ArrayList
        ArrayList<String> countries = new ArrayList<>();

        // add elements to the ArrayList
        countries.add("Iceland");
        countries.add("America");
        countries.add("Ireland");
        countries.add("Canada");
        countries.add("");
        countries.add("Greenland");
        countries.add("");
        System.out.println("Countries: " + countries);

        // remove all even countries
        countries.removeIf(e -> e.length() == 0);
        System.out.println("Countries with name: " + countries);
    }
}
