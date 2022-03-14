package FIDemo2;

public class Runnable {
    public static void main(String[] args) {

        // each functional interface has ONE abstract method called the functional method.
        // thus, the interface implementation represents only a single behavior
        // the interface can still contain any number of default or static members.
        // Java 8 introduces annotation @FunctionalInterface to indicate the above property.
        // typically, these interfaces are represented as lambda expressions, method reference,
        // and constructor references.
        // you can still declare additional abstract methods if they override something from Object.

        // implicit access through intermediate method
        Food steak = new Food();
        steak.msg();

        // direct access
        steak.c.cook();
        System.out.println(steak.mf.f(2));

        // apply the same function across multiple classes with outputs customized for each class.
        Water myDrink = new Water();
        Food myFood = new Food();
        myFood.c.cook();
        myDrink.c.cook();

        // thus far, all of this has been the same as a normal interface.
        // the motivation for FUNCTIONAL INTERFACE is that it can be instantiated and defined dynamically.
        // note how the below code does not use Food class at all.
        MysteryMathFunction mf = (n) -> (2 * n + 1);
        int myValue = mf.f(3);
        System.out.println(myValue);

        mf = (n) -> (3 * n + 2);
        myValue = mf.f(3 * mf.VALUE);
        System.out.println(myValue);
    }
}
