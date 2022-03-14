package org.sujata.myfirstpackage;

import java.util.Scanner;

public class MonetaryUnits {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("How many dollars? ");
        double dUserMoney = userInput.nextDouble();

        int iUserMoneyTotalPennies = (int)(dUserMoney * 100);
//        System.out.println("Total pennies = " + iUserMoneyTotalPennies);

        int iDollars = iUserMoneyTotalPennies / 100;
        System.out.println("Single dollars: " + iDollars);

        int iRemainingPennies = iUserMoneyTotalPennies % 100;
//        System.out.println("Remaining cents: " + iRemainingPennies);

        int iQuarters = iRemainingPennies / 25;
        iRemainingPennies %= 25;

        int iDimes = iRemainingPennies / 10;
        iRemainingPennies %= 10;

        int iNickels = iRemainingPennies / 5;
        iRemainingPennies %= 5;

        System.out.println("Quarters: " + iQuarters);
        System.out.println("Dimes: " + iDimes);
        System.out.println("Nickels: " + iNickels);
        System.out.println("Pennies: " + iRemainingPennies);
    }
}
