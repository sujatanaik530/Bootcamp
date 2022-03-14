package com.shapesdemo;

public class Circle extends Shape implements DrawPlan {
    // We can implement more than one interface.
    // We can only extend one class.

    final double PI = Math.PI;
    private double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    protected double getArea() {
        return PI + Math.pow(this.radius, 2);
    }

    @Override
    protected double getVolume() {
        return 0;
    }

    @Override
    protected double getPerimeter() {
        return 2 * PI * this.radius;
    }

    @Override
    public void drawShape(String color) {

    }

    @Override
    public void drawOnXAxis(int x) {

    }

    @Override
    public void drawOnYAxis(int y) {

    }
}
