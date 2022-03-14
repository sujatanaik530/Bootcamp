package com.teksystems;

public class Shape {
    // Every class is a reference type.
    // The Object class is a super class of every class.

    // class variables
    // global variables (can be accessed anywhere within the class)
    // automatically initialized (0 or null)
    // can use access modifiers (to control access): preferable private or protected
    // should have getter/setter method for each class variable

    protected double width;
    protected double height;
    protected double radius;
    protected double area;
    protected String name;

    // constructor
    // JVM creates a constructor without any argument for every class, which does not have one.
    public Shape() {
    }

    // overloaded constructor
    // must have different number/data type of arguments
    public Shape(double width, double height, String name) {
        this.width = width;
        this.height = height;
        this.name = name;
    }

    public Shape(double width, double height) {
        this.width = width;
        this.height = height;
    }

    //another constructor
    public Shape(double radius) {
        this.radius = radius;
    }

    // getter for width
    public double getWidth() {
        return this.width;
    }

    // setter for width
    public void setWidth(double width) {
        this.width = width;
    }

    // getter for height
    public double getHeight() {
        return this.height;
    }

    // setter for height
    public void setHeight(double height) {
        this.height = height;
    }

    // getter for radius
    public double getRadius() {
        return this.radius;
    }

    // setter for radius
    public void setRadius(double radius) {
        this.radius = radius;
    }

    // getter for name
    public String getName() {
        return this.name;
    }

    // setter for name
    public void setName(String name) {
        this.name = name;
    }

    // a method
    public void printMessage() {
        System.out.println("The first method");
    }

    // a method returning a string
    public String returnMessage() {
        return "The second method";
    }

    public double getPerimeter() {
        return 2.0 * (this.height + this.width);
    }
    public double getArea() {
        return this.height * this.width;
    }
}
