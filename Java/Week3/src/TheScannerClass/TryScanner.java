package TheScannerClass;

import java.util.Scanner;

public class TryScanner {
    public static void main(String[] args) {

        // create an object of the Scanner class

        System.out.println("Enter your name: ");
        Scanner consoleInput = new Scanner(System.in);
        String myName = consoleInput.nextLine();
        System.out.println("Your name is " + myName + ".");

        System.out.println("Enter your age: ");
        int myAge = consoleInput.nextInt();
        System.out.println("Your age is " + myAge + " years.");

        consoleInput.close();
    }
}
