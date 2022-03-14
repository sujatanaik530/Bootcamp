package TheScannerClass;

public class ControlFlow {
    public static void main(String[] args) {
        // if-else
        System.out.println("\nControl flow with if-else...");
        int age = 20;
        if (age > 25) {
            System.out.println("Age > 25");
        }
        else if (age > 20) {
            System.out.println("Age > 20");
        }
        else {
            System.out.println("Age <= 20");
        }
        System.out.println("\nAnother control flow with if-else...");
        int num = 35;
        if (num % 2 == 0) {
            System.out.println(num + " is an even number");
        }
        else {
            System.out.println(num + " is an odd number");
        }

        System.out.println("\nAnother control flow with if-else...");
        int score = 87;
        if (score < 50) {
            System.out.println("Score " + score + " is grade F");
        }
        else if ((score >= 50) && (score < 60)){
            System.out.println("Score " + score + " is grade D");
        }
        else if ((score >= 60) && (score < 80)){
            System.out.println("Score " + score + " is grade C");
        }
        else if ((score >= 80) && (score < 90)){
            System.out.println("Score " + score + " is grade B");
        }
        else if ((score >= 90) && (score <= 100)){
            System.out.println("Score " + score + " is grade A");
        }
        else {
            System.out.println("Invalid score");
        }

        System.out.println("\nAnother control flow with if-else...");
        int myage = 35;
        int wt = 120;
        int zipcode = 11123;
        if (myage > 18) {
            if (wt > 100) {
                if (zipcode == 11123) {
                    System.out.println("Service available in your area");
                } else {
                    System.out.println("Try a different area");
                }
            } else {
                System.out.println("Underweight");
            }
        }
        else {
            System.out.println("Underage");
        }

        System.out.println("\nControl flow with switch case...");
        int mynum = 10;
        switch (mynum) {
            case 10:
                System.out.println("case 10 executed");
                break;
            case 20:
                System.out.println("case 20 executed");
                break;
            case 30:
                System.out.println("case 30 executed");
                break;
            default:
                System.out.println("default case executed");
                break;
        }
    }
}
