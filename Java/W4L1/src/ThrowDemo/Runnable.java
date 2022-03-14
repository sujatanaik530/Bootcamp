package ThrowDemo;

public class Runnable {
    public static void main(String[] args) {
        UseThrow ut = new UseThrow();
        try {
            ut.checkEligibility(20, 4.0);
            ut.checkEligibility(12, 1.99);
        }
        catch (ArithmeticException e) {
            System.out.println("Student not eligible for registration");
        }
    }
}
