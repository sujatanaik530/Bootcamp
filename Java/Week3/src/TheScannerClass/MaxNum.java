package TheScannerClass;

import java.util.Arrays;
import java.util.Scanner;

public class MaxNum {
    public static void main(String[] args) {
        System.out.println("Let's create an array and find the maximum number in your array.");
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

        int maxNum = numArray[0];
        for (int eachNum: numArray) {
            if (eachNum > maxNum) {
                maxNum = eachNum;
            }
        }
        System.out.println("\nMaximum of " + Arrays.toString(numArray) + " is " + maxNum);
    }
}
