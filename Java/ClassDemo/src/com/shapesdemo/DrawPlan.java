package com.shapesdemo;

public interface DrawPlan {
    /*
     An interface contains:
        (1) only public, static and final variables
        (2) only public, abstract methods
    */

    String NAME = "MyShape"; // no need to specify public static final, it is by default.

    void drawShape(String color); // no need to specify public abstract, it is by default.
    void drawOnXAxis(int x);
    void drawOnYAxis(int y);

    // non-abstract methods are not allowed in an interface.

    /*void doSomething() {

    }*/
 }
