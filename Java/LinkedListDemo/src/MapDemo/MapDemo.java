package MapDemo;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapDemo {
    public static void main(String[] args) {
        // Maps store key-value pairs.
        // Maps are a generic class with two generic variables.
        // Map -> HashMap, TreeMap, EnumMap

        // generic type
        Map m = new HashMap<>();

        Map<Integer, String> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        Map<String, String> map3 = new HashMap<>();
        Map<Double, Double> map4 = new HashMap<>();

        // Keys have to be unique, values may repeat

        HashMap<Integer, String> stMap = new HashMap<>();
        stMap.put(1, "Student 1");
        stMap.put(2, "Student 2");
        stMap.put(3, "Student 3");
        stMap.put(4, "Student 4");
        stMap.put(5, "Student 5");
        stMap.put(6, "Student 6");
        stMap.put(7, "Student 7");

        // This will replace the value already there.
        stMap.put(1, "Student 8");

        // We can also put in a null.
        stMap.put(9, null);
        stMap.put(null, null);
        stMap.put(null, "Null");
        System.out.println(stMap);

        System.out.println("\nSize of the Map " + stMap.size());

        System.out.println("\nKeys in the Map " + stMap.keySet());

        System.out.println("\nValues in the Map " + stMap.values());

        System.out.println("\nEnhanced for loop for values");
        for (String v: stMap.values()) {
            System.out.println(v);
        }

        System.out.println("\nEnhanced for loop for keys");
        for (Integer k: stMap.keySet()) {
            System.out.println(k);
        }

        System.out.println("\nKeys and values");
        System.out.println(stMap.entrySet());

        System.out.println("\nEnhanced for with entrySet");
        for (Map.Entry<Integer, String> kv : stMap.entrySet()) {
            System.out.println(kv.getKey() + " -> " + kv.getValue());
        }

        System.out.println("\nDisplay lambda function or expression");
        stMap.forEach((key, value) -> {
            System.out.println(key + " : " + value);
        });

        // TreeMap -> SortMap -> Map
        // Duplicate keys not allowed, duplicate values not allowed
        // Key can't be null, but values can be null
        // Ascending order by default
        // Value can be any reference class

        System.out.println("\nTreeMap");
        TreeMap<String, String> tmap = new TreeMap<>();
        TreeMap<Integer, String> tmap2 = new TreeMap<>();
        TreeMap<String, Integer> tmap3 = new TreeMap<>();

        // Value can also be any class
        TreeMap<Integer, MyClass> tmap4 = new TreeMap<Integer, MyClass>();

        tmap2.put(6, "NY");
        tmap2.put(1, "AZ");
        tmap2.put(5, "NC");
        tmap2.put(2, "TX");
        tmap2.put(3, "CA");

        // not allowed
        //tmap2.put(null, "NJ");

        tmap2.put(-22, "PA");
        tmap2.put(45, null);
        System.out.println(tmap2);
        System.out.println("\nKeys -> " + tmap2.keySet());
        System.out.println("\nValues -> " + tmap2.values());
        System.out.println("\nDescending/reverse order");
        System.out.println(tmap2.descendingKeySet());
        System.out.println();
        System.out.println(tmap2.descendingMap());

        // returns key-value pairs with keys < specified number
        System.out.println(tmap2.headMap(3));

        // returns key-value pairs with keys >= specified number
        System.out.println(tmap2.tailMap(3));

        // returns key-value pairs with keys in a specified range
        System.out.println(tmap2.subMap(3,6));

        // returns key-value pairs with keys in a specified range
        System.out.println(tmap2.subMap(3, true, 6, true));
    }
}
