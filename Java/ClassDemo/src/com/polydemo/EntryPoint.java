package com.polydemo;

public class EntryPoint {
    public static void main(String[] args) {
        Animal c = new Cat();
        Animal d = new Dog();
        // The use of the parent class Animal in the declarations above is called upcasting of objects.

        c.makeSound();
        d.makeSound();

        c.eatFood("tuna");
        d.eatFood("chicken");
    }
}
