package Day2;

public class CoreJavaLoops {
    public static void main(String[] args) {
        fnOne();
        fnTwo();
        fnThree();
        fnFour();
        fnFive();
        fnSix();
        fnSeven();
        fnEight();
        fnNine();
    }

    static void fnOne() {
    /* Write a program that uses a for-loop to loop through the numbers 1-10 and prints out each number. */
        System.out.println("Using a for loop to loop through and print numbers from 1 to 10");
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }
    }

    static void fnTwo(){
    /* Write a program that uses a while loop to loop through the numbers 0-100 in increments of 10 and prints out
        each number. */
        System.out.println("Using a while loop to loop through the numbers 0-100 in increments of 10 and print out each number");
        int x = 0;
        while (x <= 100){
            System.out.println(x);
            x += 10;
        }
    }

    static void fnThree() {
    /* Write a program that uses a do-while loop to loop through the numbers 1-10 and prints out each number. */
        System.out.println("Using a do-while loop to loop through the numbers 1-10 and print out each number");
        int x = 1;
        do {
            System.out.println(x);
            x++;
        } while (x <= 10);
    }

    static void fnFour() {
    /* Write a program that uses a for-loop to loop through the numbers 1-100. Print out each number if is a multiple
        of 5, but do not print out any numbers between 25 and 75. Use the “continue” statement to accomplish this. */
        System.out.println("Using a for loop to loop through the numbers 1-100 and printing out each number");
        System.out.println("if is a multiple of 5, but not between 25 and 75.");
        for(int i = 1; i <= 100; i++) {
            if ((i >= 25) && (i <= 75)) {
                continue;
            }
            else if ((i % 5) == 0) {
                System.out.println(i);
            }
        }
    }

    static void fnFive() {
    /* Write a program that uses a for-loop to loop through the numbers 1-100. Print out each number if is a multiple
        of 5, but do not print out any numbers greater than 50. Use the “break” keyword to accomplish this. */
        System.out.println("Using a for loop to loop through the numbers 1-100 and printing out each number if is a ");
        System.out.println("multiple of 5, but do not print out any numbers greater than 50.");
        for(int i = 1; i <= 100; i++) {
            if (i > 50) {
                continue;
            }
            else if ((i % 5) == 0) {
                System.out.println(i);
            }
        }
    }

    static void fnSix() {
    /* Write a program that uses nested for-loops to output the following:
        Week 1:
        Day 1
        Day 2
        Day 3
        Day 4
        Day 5
        Week 2:
        Day 1
        Day 2
        Day 3
        Day 4
        Day 5 */
        for (int i = 1; i <= 2; i++) {
            System.out.println("Week " + i + ":");
            for (int j = 1; j <= 5; j++) {
                System.out.println("Day " + j);
            }
        }
    }

    static void fnSeven() {
    /* Write a program that returns all the available palindromes within 10 and 200. The following output will be
       produced:
            11, 22, 33, 44, 55, 66, 77, 88, 99, 101, 111, 121, 131, 141, 151, 161, 171, 181, 191,
     */
        for (int i = 10; i < 200; i++) {
            String stri = String.valueOf(i);
            int strilen = stri.length();
            boolean palindrome = true;
            for (int j = 0; j < strilen/2; j++) {
                if (stri.charAt(j) != stri.charAt(strilen-1-j)) {
                    palindrome = false;
                    break;
                }
            }
            if (palindrome == true) {
                System.out.println(i);
            }
        }
    }

    static void fnEight() {
    /* Write a program that prints the Fibonacci Sequence from 0 to 50. The following output will be produced:
        0, 1, 1, 2, 3, 5, 8, 13, 21, 34,
     */
        System.out.println("Fibonacci sequence from 0 to 50");
        int sum = 0;
        int n1 = 0;
        int n2 = 1;
        System.out.print(n1 + ", " + n2 + ", ");
        sum = n1 + n2;
        while (sum <= 50) {
            System.out.print(sum + ", ");
            n1 = n2;
            n2 = sum;
            sum = n1 + n2;
        }
    }

    static void fnNine() {
    /* Write a program that nests a for-loop inside another. Print out the inner and outer variable (e.g., i or j) in
        the inner loop (e.g., System.out.println("Inner loop: i: " + i + ", j: " + j);).
     */
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.println("Inner loop: i: " + i + ", j: " + j);
            }
        }
    }
}
