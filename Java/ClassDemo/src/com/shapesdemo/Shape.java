package com.shapesdemo;

public abstract class Shape {
    protected abstract double getArea();
    protected abstract double getVolume();
    protected abstract double getPerimeter();

    protected void showMsg() {
        System.out.println("This is the Shape class");
    }
}
