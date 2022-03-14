package com.shapesdemo;

public class Rectangle extends Shape {
    private double width;
    private double height;

    @Override
    protected double getArea() {
        return this.width * this.height;
    }

    @Override
    protected double getVolume() {
        return 0;
    }

    @Override
    protected double getPerimeter() {
        return 2 * (this.width + this.height);
    }

    public Rectangle() {
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return this.width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
