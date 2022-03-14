package com.perscholas.java_basics;

public class CoreJavaOperatorsNumbers {
    public static void main(String[] args) {
        // Write the following integers in binary notation. Do not use any Java functions or online conversion
        // applications to calculate the answer as this will hinder the learning process and your understanding
        // of the concept. However, you may check your answers using Java methods.
        // 1        2^0                                 00000001
        // 8        2^3                                 00001000
        // 33       2^5 + 1                             00100001
        // 78       2^6 + 2^3                           01001110
        // 787      2^9 + 2^8 + 2^4 + 2^1 + 2^0         00000011 00010011
        // 33,987   2^15 + 2^10 + 2^7 + 2^6 + 2^1 + 2^0 10000100 11000011

        // Convert the following binary numbers to decimal notation. Do not use any Java functions or online
        // conversion applications to calculate the answer as this will hinder the learning process and your
        // understanding of the concept. However, you may check your answers using Java methods.
        // 0010                 2
        // 1001                 9
        // 0011 0100            52
        // 0111 0010            114
        // 0010 0001 1111       543
        // 0010 1100 0110 0111  11367

        System.out.println("3----------bitwise left shift by 1----------");
        // Write a program that declares an integer a variable x and assigns the value 2 to it and prints out the
        // binary string version of the number ( Integer.toBinaryString(x) ). Now, use the left shift operator
        // (<<) to shift by 1 and assign the result to x. Before printing the results, write a comment with the
        // predicted decimal value and binary string. Now, print out x in decimal form and in binary notation. Do
        // the preceding exercise with the following values: 9 17 88
        int x = 2;
        System.out.println("\nBinary string version of " + x + " is " + Integer.toBinaryString(x));
        x = x << 1;
        System.out.println("Bitwise left shift by 1 will give 4 which is 100 in binary.");
        System.out.println("New binary string version of " + x + " is " + Integer.toBinaryString(x));

        x = 9;
        System.out.println("\nBinary string version of " + x + " is " + Integer.toBinaryString(x));
        x = x << 1;
        System.out.println("Bitwise left shift by 1 will give 18 which is 10010 in binary.");
        System.out.println("New binary string version of " + x + " is " + Integer.toBinaryString(x));

        x = 17;
        System.out.println("\nBinary string version of " + x + " is " + Integer.toBinaryString(x));
        x = x << 1;
        System.out.println("Bitwise left shift by 1 will give 34 which is 00100010 in binary.");
        System.out.println("New binary string version of " + x + " is " + Integer.toBinaryString(x));

        x = 88;
        System.out.println("\nBinary string version of " + x + " is " + Integer.toBinaryString(x));
        x = x << 1;
        System.out.println("Bitwise left shift by 1 will give 176 which is 10110000 in binary.");
        System.out.println("New binary string version of " + x + " is " + Integer.toBinaryString(x));

        System.out.println("\n4----------bitwise right shift by 2----------");
        // Write a program that declares a variable x and assigns 150 to it and prints out the binary string
        // version of the number. Now use the right shift operator (>>) to shift by 2 and assign the result to x.
        // Write a comment indicating what you anticipate the decimal and binary values to be. Now print the value
        // of x and the binary string.
        // Do the preceding exercise with the following values: 225 1555 32456
        x = 150;
        System.out.println("\nBinary string version of " + x + " is " + Integer.toBinaryString(x));
        x = x >> 2;
        System.out.println("Bitwise right shift by 2 will give 37 which is 100101 in binary.");
        System.out.println("New binary string version of " + x + " is " + Integer.toBinaryString(x));

        x = 225;
        System.out.println("\nBinary string version of " + x + " is " + Integer.toBinaryString(x));
        x = x >> 2;
        System.out.println("Bitwise right shift by 2 will give 56 which is 00111000 in binary.");
        System.out.println("New binary string version of " + x + " is " + Integer.toBinaryString(x));

        x = 1555;
        System.out.println("\nBinary string version of " + x + " is " + Integer.toBinaryString(x));
        x = x >> 2;
        System.out.println("Bitwise right shift by 2 will give 388 which is 110000100 in binary.");
        System.out.println("New binary string version of " + x + " is " + Integer.toBinaryString(x));

        x = 32456;
        System.out.println("\nBinary string version of " + x + " is " + Integer.toBinaryString(x));
        x = x >> 2;
        System.out.println("Bitwise right shift by 2 will give 8114 which is 1111110110010 in binary.");
        System.out.println("New binary string version of " + x + " is " + Integer.toBinaryString(x));

        System.out.println("\n5---------bitwise & and | -----------");
        x = 7;
        int y = 17;
        System.out.println("Bitwise & on " + x + " and " + y + " will give 1");
        int z = x & y;
        System.out.println(x + " bitwise & " + y + " is " + z);

        System.out.println("Bitwise | on " + x + " and " + y + " will give 23");
        z = x | y;
        System.out.println(x + " bitwise | " + y + " is " + z);

        System.out.println("\n6---------postfix increment-----------");
        // Write a program that declares an integer variable, assigns a number, and uses a postfix increment
        // operator to increase the value. Print the value before and after the increment operator.
        x = 7;
        System.out.println("Before the postfix increment, x is " + x++);
        System.out.println("After the postfix increment, x is " + x);

        System.out.println("\n7---------three ways to increment by 1-----------");
        // Write a program that demonstrates at least 3 ways to increment a variable by 1 and does this multiple
        // times. Assign a value to an integer variable, print it, increment by 1, print it again, increment by 1,
        // and then print again.
        x = 7;
        System.out.println("x = " + x);
        x = x + 1;
        System.out.println("x = " + x);
        x += 1;
        System.out.println("x = " + x);
        x++;
        System.out.println("x = " + x);

        System.out.println("\n8---------prefix and postfix increment-----------");
        // Write a program that declares 2 integer variables, x, and y, and then assigns 5 to x and 8 to y. Create
        // another variable sum and assign the value of ++x added to y and print the result. Notice the value of
        // the sum (should be 14). Now change the increment operator to postfix (x++) and re-run the program.
        // Notice what the value of sum is. The first configuration incremented x and then calculated the sum while
        // the second configuration calculated the sum and then incremented x.
        x = 5;
        y = 8;
        System.out.println("x = " + x + ", y = " + y + ", y + ++x gives");
        int sum = y + ++x;
        System.out.println("sum = " + sum);

        System.out.println("Resetting x to 5 and y to 8");
        x = 5;
        y = 8;
        System.out.println("x = " + x + ", y = " + y + ", y + x++ gives");
        sum = y + x++;
        System.out.println("sum = " + sum);
    }
}
