package ThrowDemo;

public class UseThrow {
    public void checkEligibility (int sAge, double sGPA) {
        if (sAge < 18 && sGPA < 2) {
            // You can use the throw keyword here to manually/explicitly throw an exception.
            // You can create custom exceptions - your own rules, definitions, messages

            throw new ArithmeticException();
        }
        else {
            System.out.println("Student eligible for registration");
        }
    }
}
