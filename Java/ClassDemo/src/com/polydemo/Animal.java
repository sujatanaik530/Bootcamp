package com.polydemo;

public abstract class Animal {
    // This method NEED NOT be implemented by subclasses.
    // It MAY be implemented, though, for specialized purposes.
    public void makeSound() {
        System.out.println("???");
    };

    // This method MUST be implemented by subclasses.
    public abstract void eatFood(String food);
}
