package org.sujata.myfirstpackage;

import java.util.Scanner;

public class CircleRadius {
    public static void main(String[] args) {
        // Computing the area of a circle
        double radius;
        Scanner userInput = new Scanner(System.in);
        System.out.println("Computing are of a circle with given radius");
        System.out.println("Enter radius: ");
        radius = userInput.nextDouble();
        final double PI = 3.14159;
        double area = PI * radius * radius;
        System.out.println("The area of a circle with radius " + radius + " is " + area + ".");
    }
}
