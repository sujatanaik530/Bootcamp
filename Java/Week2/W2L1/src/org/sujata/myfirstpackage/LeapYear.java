package org.sujata.myfirstpackage;

public class LeapYear {
    public static void main(String[] args) {
        int inputYear = 2050;
        boolean bLeap;
        if ((inputYear % 400) == 0) {
            bLeap = true;
        }
        else if ((inputYear % 100) == 0) {
            bLeap = false;
        }
        else if ((inputYear % 4) == 0) {
            bLeap = true;
        }
        else {
            bLeap = false;
        }
        if (bLeap == true) {
            System.out.println(inputYear + " is a leap year.");
        }
        else {
            System.out.println(inputYear + " is not a leap year.");
        }
    }
}
