package org.sujata.myfirstpackage;

public class OperatorsExamples {
    public static void main(String[] args) {
        boolean c = (1 < 2);
        System.out.println("c is " + c);

        int score = 10;
        int temp = 200;
        boolean rs = (score >= 10) && (temp >= 300);
        System.out.println("rs is " + rs);

        boolean rs2 = (score >= 10) || (temp >= 300);
        System.out.println("rs2 is " + rs2);

        System.out.println("-------------bitwise operators----------");

        byte b1 = 3;    // 00000011
        byte b2 = 4;    // 00000100

        int bOR = b1 | b2;
        System.out.println("bOR = " + bOR);

        int bAND = b1 & b2;
        System.out.println("bAND = " + bAND);

        int bXOR = b1 ^ b2;
        System.out.println("bXOR = " + bXOR);

        int bCOMPL = ~b1;
        System.out.println("bCOMPL = " + bCOMPL);

        int bLSHIFT = b1 << 2;
        System.out.println("bLSHIFT = " + bLSHIFT);

        int bRSHIFT = b1 >> 2;
        System.out.println("bRSHIFT = " + bRSHIFT);

        System.out.println("-------------logical operators----------");
        int age = 24;
        int weight = 140;
        boolean rs3 = (age > 34) ^ (weight > 140);
        System.out.println(rs3);

        boolean rs4 = (age > 14) ^ (weight > 140);
        System.out.println(rs4);

        boolean rs5 = (age > 14) ^ (weight > 40);
        System.out.println(rs5);

        boolean rs6 = (age > 25) ^ (weight > 40);
        System.out.println(rs6);

        System.out.println("-------------assignment operators----------");

        int x = 55;
        System.out.println("x is " + x);
        x += 5;
        System.out.println("After += 5, x is now " + x);

        x -= 5;
        System.out.println("After -= 5, x is now " + x);

        x /= 5;
        System.out.println("After /= 5, x is now " + x);

        x *= 5;
        System.out.println("After *= 5, x is now " + x);

        x = 10;
        System.out.println("The ++ is not here yet. x is still " + x++);
        System.out.println("After the previous ++, x is now " + x);
        System.out.println("The ++ here is already here. x is now " + ++x);
    }
}
