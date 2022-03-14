package SetDemo;

import sun.reflect.generics.tree.Tree;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
    public static void main(String[] args) {
        // Set always has unique elements.
        // Set is an interface, cannot be instantiated.
        // TreeSet, HashSet
        // A tree is a recursive data structure where each node can have two children at most.
        // Hashing is a technique used to uniquely identify a specific object from a group of similar objects.
        // Hashes are not meant to be sorted.

        Set<String> hS = new HashSet<>();
        Set<String> tS = new TreeSet<>();

        // HashSet -> Set -> Collection -> Iterator
        HashSet hsObj = new HashSet();
        hsObj.add(1);
        hsObj.add("Sujata");
        hsObj.add(true);

        HashSet<String> stSet = new HashSet<>();
        stSet.add("USA");
        stSet.add("UK");
        stSet.add("UAE");
        stSet.add("Australia");
        stSet.add(null);

        System.out.println(stSet);

        HashSet<Integer> setOne = new HashSet<>();
        for (int i = 0; i < 2000; i++)
        {
            setOne.add((int)((700 * Math.random()) * (900 * Math.random())));
        }
        System.out.println("\nSize of random set " + setOne.size());
        System.out.println("\nRandom set " + setOne);
/*        setOne.add(4);
        setOne.add(3);
        setOne.add(2);
        setOne.add(1);*/

        HashSet<Integer> setTwo = new HashSet<>();
        setTwo.add(8);
        setTwo.add(7);
        setTwo.add(6);
        setTwo.add(5);

        System.out.println();
        System.out.println("Set one " + setOne);
        System.out.println("Set two " + setTwo);
        setOne.addAll(setTwo);
        System.out.println("New Set one " + setOne);
        setTwo.addAll(setOne);
        System.out.println("New Set two " + setTwo);

        // TreeSet values are stored in ascending order by default. Null values are not allowed.
        TreeSet<String> tsObj = new TreeSet<>();
        tsObj.add("New York");
        tsObj.add("Minnesota");
        tsObj.add("New Jersey");
        tsObj.add("Texas");
        tsObj.add("Ohio");
        System.out.println("\nPrinting TreeSet");
        System.out.println(tsObj);

        TreeSet<Integer> tsIObj = new TreeSet<>();
        tsIObj.add(34);
        tsIObj.add(44);
        tsIObj.add(434);
        tsIObj.add(3);
        tsIObj.add(3224);
        tsIObj.add(4);
        System.out.println("\nPrinting Integer TreeSet");
        System.out.println(tsIObj);

    }
}
