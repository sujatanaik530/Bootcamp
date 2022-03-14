package ArrayListDemo;

import java.util.*;

public class ArrayListDemo {
    public static void main(String[] args) {
        // ArrayList is generic type

        // this list is not type safe
        ArrayList list1 = new ArrayList();

        // Use the add() method to initialize list1
        list1.add("Sujata");
        list1.add(32);
        list1.add(true);
        list1.add(23.11);

        // this list is type safe
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("Sujata");

        // the below code will not work
        //list2.add(25);

        ArrayList<Integer> sRollNums = new ArrayList<>();
        sRollNums.add(11);
        sRollNums.add(22);

        // the below code will not work
        //sRollNums.add(2.3);

        ArrayList<StudentService> stSer = new ArrayList<>();
        // upcasting
        // List is not ArrayList
        // ArrayList is List

        // List is an interface, cannot be instantiated
        //ArrayList<String> a = new List<>();

        List<String> l = new ArrayList<>();

        // The asList() method can be used instead of the add() method.
        List listOne = Arrays.asList(1, "Sujata", 3.14);
        List<String> listTwo = Arrays.asList("Sujata", "Next 1", "Next 2");

        // Using a for loop to go through an ArrayList
        System.out.println("\nPrinting with the enhanced for loop");
        for (String listItem: listTwo) {
            System.out.println(listItem);
        }

        // Using Iterator to traverse the list
        System.out.println("\nPrinting with an Iterator");
        Iterator itr = listTwo.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        // Printing with the foreach() method (lambda)
        System.out.println("\nPrinting with the foreach() method (lambda)");
        listTwo.forEach(n -> System.out.println(n));

        // This one prints the list items in square brackets.
        System.out.println("\nPrinting brute force");
        System.out.println(listTwo);

        // Using the addall() method, we can add everything from one collection into another.
        System.out.println("\nUsing addAll()");
        List<Integer> primeNumber = new ArrayList<>();
        //primeNumber = Arrays.asList(2, 3, 5, 7);
        System.out.println(primeNumber);
        primeNumber.addAll(Arrays.asList(11, 13, 23));
        System.out.println(primeNumber);
        primeNumber.addAll(0, Arrays.asList(2, 3, 5, 7));
        System.out.println(primeNumber);
        primeNumber.addAll(6, Arrays.asList(17, 19));
        System.out.println(primeNumber);

        System.out.println("\nUsing more methods");
        ArrayList<String> sList = new ArrayList<>();
        sList.add("Student 1");
        sList.add("Student 2");
        sList.add("Student 3");
        sList.add("Student 4");
        sList.add("Student 5");
        System.out.println("The list is " + sList);
        System.out.println("Number of elements in the list is " + sList.size());
        System.out.println("Element at index 2 is " + sList.get(2));
        System.out.println("Index of Student 5 is " + sList.indexOf("Student 5"));
        System.out.println("Removing Student 3");
        sList.remove("Student 3");
        System.out.println(sList);
        System.out.println("Removing element at index 1");
        sList.remove(1);
        System.out.println(sList);

        System.out.println("\nWith numbers");
        ArrayList<Integer> sRolls = new ArrayList<>();
        sRolls.add(1);
        sRolls.add(22);
        sRolls.add(3);
        sRolls.add(4);
        sRolls.add(25);
        sRolls.add(6);
        System.out.println();
        System.out.println(sRolls);
        sRolls.remove(1); // this 1 points to the index, not the element 1
        System.out.println(sRolls);

        System.out.println("\nSorting!");
        System.out.println(sRolls);
        Collections.sort(sRolls);
        System.out.println(sRolls);

        System.out.println("\nReversing");
        System.out.println(sRolls);
        Collections.reverse(sRolls);
        System.out.println(sRolls);

        System.out.println("\nUsing set at index 3 to 65");
        System.out.println("Before " + sRolls);
        sRolls.set(3, 65);
        System.out.println("After " + sRolls);

        System.out.println("\nUsing contains to check for 77 and then for 6");
        System.out.println(sRolls.contains(77));
        System.out.println(sRolls.contains(6));

        System.out.println("\nUsing retainall with 1, 4, 6");
        System.out.println("Before: " + sRolls);
        sRolls.retainAll(Arrays.asList(1, 4, 6));
        System.out.println("After: " + sRolls);

        ArrayList<StudentService> stList = new ArrayList<>();
        System.out.println("\nStudents list");
        StudentService s1 = new StudentService("Student 1", 101);
        StudentService s2 = new StudentService("Student 2", 102);
        StudentService s3 = new StudentService("Student 3", 103);
        StudentService s4 = new StudentService("Student 4", 104);
        StudentService s5 = new StudentService("Student 5", 105);
        stList.add(s1);
        stList.add(s2);
        stList.add(s3);
        stList.add(s4);
        stList.add(s5);

        // ArrayList of StudentService objects
        for (StudentService s: stList) {
            System.out.println(s.getsName() + " " + s.getsRNum());
        }

        System.out.println("\nTeachers list");
        ArrayList<Teacher> tList = new ArrayList<>();
        Teacher t1 = new Teacher(200, "Teacher 1", 40);
        Teacher t2 = new Teacher(201, "Teacher 2", 25);
        Teacher t3 = new Teacher(202, "Teacher 3", 50);
        Teacher t4 = new Teacher(203, "Teacher 4", 34);
        Teacher t5 = new Teacher(204, "Teacher 5", 60);

        tList.add(t1);
        tList.add(t2);
        tList.add(t3);
        tList.add(t4);
        tList.add(t5);

        Iterator itr1 = tList.iterator();
        while (itr1.hasNext()) {
            Teacher tempT = (Teacher)itr1.next();
            System.out.println(tempT.getTid() + " " + tempT.getTname() + " " + tempT.getTage());
        }

        // Using the new StudentController class
        System.out.println("\nGetting data from StudentController");
        StudentController con = new StudentController();
        ArrayList<StudentService> sList2 = con.pullStudentInfo();

        Iterator itr2 = sList2.iterator();
        while (itr2.hasNext()) {
            StudentService ss = (StudentService) itr2.next();
            System.out.println(ss.getsName() + " " + ss.getsRNum());
        }

        System.out.println("\nPrinting data in StudentWorking");
        StudentWorking sw = new StudentWorking();
        sw.displayStudentInfo();

        // Using the new Teacher classes
        System.out.println("\nGetting data from TeacherController");
        TeacherController tcon = new TeacherController();
        ArrayList<Teacher> tList1 = tcon.pullTeacherInfo();

        Iterator itr3 = tList1.iterator();
        while (itr3.hasNext()) {
            Teacher t = (Teacher) itr3.next();
            System.out.println(t.getTname() + " " + t.getTage() + t.getTid());
        }

        System.out.println("\nPrinting data from TeacherWorking");
        TeacherWorking tw = new TeacherWorking();
        tw.displayTeacherInfo();

        System.out.println("\nReading student data from a comma-delimited file");
        ArrayList<StudentService> sfList = new ArrayList<>();
        sfList = con.readStudentDataFromFile();

        Iterator itr4 = sfList.iterator();
        while (itr4.hasNext()) {
            StudentService s = (StudentService) itr4.next();
            System.out.println(s.getsRNum() + " " + s.getsName());
        }

        System.out.println("\nPrinting student data from file in student working");
        sw.displayStudentInfoFromFile();
    }
}
