package W4L1;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExceptionsExample {
    // You can use the throws keyword with multiple exception, separated by commas
    public static void main (String[] args){
        //Ex1();
        //Ex2();
        //Ex3();
        //Ex4();
        //Ex5();
        try {
            Ex6();
        }
        catch (FileNotFoundException e) {
            System.out.println("Handled in main");
        }
    }

    // unchecked exceptions: programmer's mistake, because of insufficient checks (if statements)
    public static void Ex1() {
        System.out.println("This statement before the exception causing statement will be executed");
        try {
            //Integer i = new Integer('ss');

            // here is an unchecked exception - not caught by compiler, but caught at runtime
            int a = 100 / 0;
            System.out.println("This statement after the exception causing statement will not be executed");
        }
        catch (ArithmeticException e) {
            System.out.println("Exception caught: You cannot use zero in the denominator\n" + e);
            e.printStackTrace();
        }
        finally {
            // finally is optional
            // This code is always executed, whether there is an exception or not.
            // There can be a try-catch in finally e.g. when you are trying to close a file.
            System.out.println("End program gracefully, release resources here");
        }
        System.out.println("This statement after catch will be executed");
    }

    public static void Ex2() {
        System.out.println("This statement before the exception causing statement will be executed");
        try {
            // here is an unchecked exception - not caught by compiler, but caught at runtime
            String s = null;
            s.length();
            System.out.println("This statement after the exception causing statement will not be executed");
        } catch (NullPointerException e) {
            System.out.println("Exception caught: You cannot find the length of a null string\n" + e);
            e.printStackTrace();
        }
        System.out.println("This statement after catch will be executed");
    }

    public static void Ex3() {
        System.out.println("This statement before the exception causing statement will be executed");
        try {
            // here is an unchecked exception - not caught by compiler, but caught at runtime
            int a = 100 / 10;
            String s = null;
            s.length();
            System.out.println("This statement after the exception causing statement will not be executed");
        }
        catch (ArithmeticException e) {
            System.out.println("Exception caught: You cannot have zero for a denominator\n" + e);
            e.printStackTrace();
        }
        catch (NullPointerException e) {
            System.out.println("Exception caught: You cannot find the length of a null string\n" + e);
            e.printStackTrace();
        }
        System.out.println("This statement after catch will be executed");
    }

    public static void Ex4() {
        System.out.println("This statement before the exception causing statement will be executed");
        try {
            // here is an unchecked exception - not caught by compiler, but caught at runtime
            int a = 100 / 10;
            String s = "Sujata";
            s.length();
            int[] arr = {1, 2, 3, 4, 5};
            arr[10] = 10;
            System.out.println("This statement after the exception causing statement will not be executed");
        }
        catch (ArithmeticException e) {
            System.out.println("Exception caught: You cannot have zero for a denominator\n" + e);
            e.printStackTrace();
        }
        catch (NullPointerException e) {
            System.out.println("Exception caught: You cannot find the length of a null string\n" + e);
            e.printStackTrace();
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception caught: Array too small\n" + e);
            e.printStackTrace();
        }
        System.out.println("This statement after catch will be executed");
    }

    public static void Ex5() {
        // checked exception - checked and reported at compile time
        // just the following statement without try-catch or throws on the method will give an error.
        // code won't execute until we handle it in one of the above two ways.
        try {
            FileReader f = new FileReader("abc.txt");
        }
        catch (Exception e) {
            System.out.println("Caught exception");
        }
    }

    public static void Ex6() throws FileNotFoundException {
        // checked exception - checked and reported at compile time
        // just the following statement without try-catch or throws on the method will give an error.
        // code won't execute until we handle it in one of the above two ways.
        FileReader f = new FileReader("abc.txt");
    }
}
