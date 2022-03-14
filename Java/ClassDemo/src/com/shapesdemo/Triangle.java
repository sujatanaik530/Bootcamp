package com.shapesdemo;

public class Triangle extends Shape{
    private int tlength;
    public Triangle() {
    }

    public int getTlength() {
        return tlength;
    }

    public void setTlength(int tlength) {
        this.tlength = tlength;
    }

    @Override
    protected double getArea() {
        return 0;
    }

    @Override
    protected double getVolume() {
        return 0;
    }

    @Override
    protected double getPerimeter() {
        return 0;
    }
}
