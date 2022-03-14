package TheScannerClass;

import java.util.Scanner;

public class LoopsDemo {
    public static void main(String[] args) {
        // for loop
        // condition after for
        System.out.println("For loops");
        System.out.println("\nstarting at 0, end before 10");
        System.out.println("\nTypical for loop...");
        for (int i = 0; i < 10; i++){
            System.out.println("Hello! " + i);
        }

        // increment condition is incrementing by 2
        System.out.println("\nIncrementing by 2...");
        for (int i = 0; i < 10; i += 2){
            System.out.println("Hello! " + i);
        }

        // starts at 5
        System.out.println("\nStarting at 5...");
        for (int i = 5; i < 10; i++){
            System.out.println("Hello! " + i);
        }

        // increment condition is decrementing
        System.out.println("\nDecrementing by 1...");
        System.out.println("starting at 10, end at 0");
        for (int i = 10; i > 0; i--){
            System.out.println("Hello! " + i);
        }

        // nested for loops
        System.out.println("Nested for loops: 1 to 3");
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++)
                System.out.println("i = " + i + ", j = " + j);
        }

        // print a pyramid of asterisks
        System.out.println("\nA pyramid of asterisks\n");
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }

        // take input from user and check if the number is prime
        // 1 is not a prime - it only has one divisor
        System.out.println("\nEnter a number: ");
        Scanner uInput = new Scanner(System.in);
        int num = uInput.nextInt();
        boolean notprime = false;
        System.out.println(num);
        if (num == 1){
            notprime = true;
        }
        for (int  i = 2; i <= Math.round(Math.sqrt(num)); i++) {
            if ((num % i) == 0) {
                notprime = true;
                break;
            }
        }
        if (notprime == true) {
            System.out.println(num + " is not a prime number.");
        }
        else {
            System.out.println(num + " is a prime number.");
        }

        // break: loop execution stops at break
        System.out.println("\nUsing break with for - does not print 4, stops");
        for (int i = 0; i < 10; i++) {
            if (i == 4) {
                break;
            }
            System.out.println(i);
        }
        // continue: loop execution restarts with next value
        System.out.println("\nUsing continue with for - skips 4, continues");
        for (int i = 0; i < 10; i++) {
            if (i == 4) {
                continue;
            }
            System.out.println(i);
        }
    }
}
