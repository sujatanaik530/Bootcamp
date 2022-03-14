package TheScannerClass;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {
        System.out.println("Let's create an array and then reverse it.");
        System.out.println("How many numbers in your array? ");
        Scanner userInput = new Scanner(System.in);

        int arrLength = userInput.nextInt();
        userInput.nextLine();

        int[] numArray = new int[arrLength];
        for (int i = 0; i < arrLength; i++) {
            System.out.println("Enter number: ");
            numArray[i] = userInput.nextInt();
            userInput.nextLine();
        }

        int[] revIntArray = new int[numArray.length];
        for(int j = 0; j < numArray.length ; j++) {
            revIntArray[j] = numArray[numArray.length - 1 - j];
        }
        System.out.println("\nReverse of " + Arrays.toString(numArray) + " is " + Arrays.toString(revIntArray));
    }
}
