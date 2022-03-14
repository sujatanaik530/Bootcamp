package com.GenericDemo;

public class EntryPoint {
    public static void main(String[] args) {
        G_methodDemo gObj = new G_methodDemo();
        gObj.genericmethod("Sujata");
        gObj.genericmethod(25);
        gObj.genericmethod(3.14);
        gObj.genericmethod(true);

        // The below wont work because mymethod only accepts int or double.
        // gObj.mymethod("Sujata");

        GenericClassDemo gcd1 = new GenericClassDemo("Sujata");
        System.out.println(gcd1.getVarOne());
        GenericClassDemo gcd2 = new GenericClassDemo(23.4);
        System.out.println(gcd2.getVarOne());
        GenericClassDemo gcd3 = new GenericClassDemo(56);
        System.out.println(gcd3.getVarOne());

        // gcd1 had a string before, but it can be changed to any data type.
        System.out.println("Changed gcd1 from string to int");
        gcd1.setVarOne(7);
        System.out.println(gcd1.getVarOne());

        String[] fruits = {"Apples", "Oranges", "Mangoes"};
        gcd1.printArray(fruits);

        Integer[] nums = {1, 4 ,5, 6, 8};
        gcd1.printArray(nums);
    }
}
