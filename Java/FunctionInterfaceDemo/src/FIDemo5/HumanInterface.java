package FIDemo5;

@FunctionalInterface
public interface HumanInterface {
    void eat(String a);

    default void sleep() {
        System.out.println("The default method is sleeping");
    }

    static void communicate() {
        System.out.println("The static method is communicating");
    }
}
