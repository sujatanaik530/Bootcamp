package com.teksystems;

public class Cylinder extends Shape {
    private double radius;

    public Cylinder() {

    }

    public Cylinder(double radius, double height) {
        super(height);  // parent class constructor
        this.radius = radius;
    }

    public double getArea() {
        super.area = 2.0 * Math.PI * this.radius * super.height;
        return super.area;
    }
}
