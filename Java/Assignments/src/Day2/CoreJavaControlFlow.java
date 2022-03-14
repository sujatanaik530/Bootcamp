package Day2;

import java.util.Scanner;

public class CoreJavaControlFlow {
        public static void main(String[] args) {
            //fnOne();
            //fnTwo();
            //fnThree();
            //fnFour();
            //fnFive();
            fnSix(); //comment out all above function calls to run this one
        }
        static void fnOne() {
        /* Write a program that declares 1 integer variable x, and then assigns 7 to it.
         Write an if statement to print out “Less than 10” if x is less than 10. Change x
         to equal 15 and notice the result (console should not display anything). */
            int x = 7;
            if (x < 10) {
                System.out.println("Less than 10");
            }
        }

        static void fnTwo() {
        /* Write a program that declares 1 integer variable x, and then assigns 7 to it.
        Write an if-else statement that prints out “Less than 10” if x is less than 10 and
        “Greater than 10” if x is greater than 10. Change x to 15 and notice the result. */
            int x = 15;
            if (x < 10) {
                System.out.println("Less than 10");
            }
            else if (x > 10) {
                System.out.println("Greater than 10");
            }
        }

        static void fnThree() {
        /* Write a program that declares 1 integer variable x, and then assigns 15 to it.
        Write an “if-else-if” statement that prints out “Less than 10” if x is less than 10,
        “Between 10 and 20” if x is greater than 10 but less than 20, and
        “Greater than or equal to 20” if x is greater than or equal to 20. Change x to 50 and
        notice the result. */
            int x = 50;
            if (x < 10) {
                System.out.println("Less than 10");
            } else if ((x > 10) && (x < 20)) {
                System.out.println("Between 10 and 20");
            } else if (x >= 20) {
                System.out.println("Greater than or equal to 20");
            }
        }

        static void fnFour() {
        /*  Write a program that declares 1 integer variable x, and then assigns 15 to it. Write an if-else
        statement that prints “Out of range” if the number is less than 10 or greater than 20 and prints “In range” if
        between 10 and 20 (including equal to 10 or 20). Change x to 5 and notice the result.*/
            int x = 5;
            if ((x < 10) || (x > 20)) {
                System.out.println("Out of range");
            }
            else {
                System.out.println("In range");
            }
        }

        static void fnFive() {
        /* Write a program that uses if-else-if statements to print out grades A, B, C, D, F according to the following
         criteria:
            A: 90-100
            B: 80-89
            C: 70-79
            D: 60-69
            F: <60
            Use the Scanner class to accept a number score from the user to determine the letter grade. Print out
            “Score out of range.” if the score is less than 0 or greater than 100. */
            Scanner uIn = new Scanner(System.in);
            System.out.println("What is your score? ");
            int score = uIn.nextInt();
            if ((score < 0) || (score > 100)) {
                System.out.println("Score out of range");
            }
            else if (score < 60) {
                System.out.println("F");
            }
            else if ((score >= 60) && (score <= 69)) {
                System.out.println("D");
            }
            else if ((score >= 70) && (score <= 79)) {
                System.out.println("C");
            }
            else if ((score >= 80) && (score <= 89)) {
                System.out.println("B");
            }
            else if ((score >= 90) && (score <= 100)) {
                System.out.println("A");
            }
            uIn.close();
        }

        static void fnSix() {
        /*  Write a program that accepts an integer between 1 and 7 from the user. Use a switch statement to print out
        the corresponding weekday. Print “Out of range” if the number is less than 1 or greater than 7. Don’t forget to
        include “break” statements in each of your cases.*/
            Scanner uIn = new Scanner(System.in);
            System.out.println("Enter a number for weekday (Sunday = 0): ");
            int weekday = uIn.nextInt();
            switch(weekday) {
                case 1:
                    System.out.println("Sunday");
                    break;
                case 2:
                    System.out.println("Monday");
                    break;
                case 3:
                    System.out.println("Tuesday");
                    break;
                case 4:
                    System.out.println("Wednesday");
                    break;
                case 5:
                    System.out.println("Thursday");
                    break;
                case 6:
                    System.out.println("Friday");
                    break;
                case 7:
                    System.out.println("Saturday");
                    break;
                default:
                    System.out.println("Out of range");
            }
        }
}
