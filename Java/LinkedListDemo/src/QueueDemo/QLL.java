package QueueDemo;

import java.util.*;

public class QLL {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();

        // priority class implementation of queue
        // Here the LinkedList is a Queue type
        Queue<String> p = new PriorityQueue<String>();
        Queue<String> queueLL = new LinkedList<String>();
        // Only Queue methods will be accessible
        queueLL.peek();

        // Here it is a List type
        List<String> listLL = new LinkedList<String>();
        // Only List methods will be accessible

        // LinkedList implements List and Queue (and Collection and Iterable)
        LinkedList llLL = new LinkedList();
        llLL.add("Sujata");
        llLL.add(25);
        llLL.add(true);

        LinkedList<Integer> intList = new LinkedList<>();
        LinkedList<Double> doubleList = new LinkedList<>();
        LinkedList<Float> floatList = new LinkedList<>();
        LinkedList<String> obj1 = new LinkedList<>();
        obj1.add("a");
        obj1.add("b");
        obj1.add("c");
        obj1.add("d");
        obj1.add("e");
        obj1.add("f");
        obj1.add("g");
        obj1.add("h");
        System.out.println("\n");
        System.out.println(obj1);
        System.out.println("Size of obj1 is " + obj1.size());
        // The add method comes from List
        // The offer method comes from Deque
        obj1.offer("i");
        obj1.offer("j");
        System.out.println("\nUsed offer twice...");
        System.out.println(obj1);
        System.out.println("Size of obj1 is " + obj1.size());
        obj1.set(0, "Sujata");
        System.out.println("\nUsed set on index 0");
        System.out.println(obj1);
        System.out.println("Size of obj1 is " + obj1.size());

        // indexOf comes from List
        System.out.println("\nUsing indexOf on c");
        System.out.println(obj1);
        System.out.println(obj1.indexOf("c"));
        // contains comes from List
        System.out.println("\nUsing contains on x");
        System.out.println(obj1);
        System.out.println(obj1.contains("x"));
        // get comes from List
        System.out.println("\nUsing get on 1");
        System.out.println(obj1);
        System.out.println(obj1.get(1));
        System.out.println("\nUsing remove on f");
        System.out.println(obj1);
        System.out.println(obj1.remove("f"));
        System.out.println(obj1);

        // using enhanced for with list
        System.out.println("\nEnhanced for...");
        for (String s: obj1) {
            System.out.print(s + " ");
        }

        System.out.println();

        // or use Iterator (parent to all collections)
        System.out.println("\nIterator");
        Iterator<String> itr = obj1.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
    }
}
