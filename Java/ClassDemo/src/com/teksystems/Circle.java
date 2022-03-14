package com.teksystems;

public class Circle extends Shape {
    private double radius;
    private final double PI = Math.PI;

    public Circle() {

    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        super.area = PI * Math.pow(this.radius, 2);
        return area;
    }
}
class Triangle extends Shape {

}
