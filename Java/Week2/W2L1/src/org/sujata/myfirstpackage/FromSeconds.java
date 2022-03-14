package org.sujata.myfirstpackage;

import java.util.Scanner;

public class FromSeconds {
    public static void main(String[] args) {
        int inputSeconds = 5670;
        Scanner insecs = new Scanner(System.in);
        System.out.println("Enter the number of seconds: ");
        inputSeconds = insecs.nextInt();
        int hrs = 0;
        int mins = 0;
        int secs = 0;

        mins = inputSeconds / 60;
        secs = inputSeconds % 60;
        hrs = mins / 60;
        mins = mins % 60;
        System.out.println(hrs + ":" + mins + ":" + secs);
        insecs.close();
    }
}
